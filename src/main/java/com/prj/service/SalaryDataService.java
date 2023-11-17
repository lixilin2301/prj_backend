package com.prj.service;

import com.prj.entity.Employee;
import com.prj.entity.SalaryData;
import com.prj.repository.EmployeeRepository;
import com.prj.repository.SalaryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryDataService {
    @Autowired
    private SalaryDataRepository salaryDataRepository;

    public void addAllSalaryData(List<SalaryData> salaryDataList) {
        salaryDataRepository.deleteAll();
        salaryDataRepository.saveAll(salaryDataList);
    }

    public List<SalaryData> getAllSalaryData() {
        return salaryDataRepository.findAll();
    }

    public List<Double> analyze() {
        return linearRegression(salaryDataRepository.findAll());
    }

    public static List<Double> linearRegression(List<SalaryData> data) {
        double n = data.size();
        double sumX = 0, sumY = 0,sumXY = 0, sumX2 = 0, MSE = 0.0;

        for (SalaryData entry : data) {
            double years = Double.parseDouble(entry.getYears());
            double salary = Double.parseDouble(entry.getSalary());
            sumX += years;
            sumY += salary;
            sumXY += years * salary;
            sumX2 += Math.pow(years, 2);
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - Math.pow(sumX, 2));
        double intercept = (sumY - slope * sumX) / n;

        for(SalaryData entry : data) {
            double years = Double.parseDouble(entry.getYears());
            double salary = Double.parseDouble(entry.getSalary());
            MSE += Math.pow(salary - (slope * years + intercept), 2);
        }

        return List.of(slope, intercept, MSE/n);
    }
}
