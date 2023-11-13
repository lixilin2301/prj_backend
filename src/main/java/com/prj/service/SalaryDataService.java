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
        salaryDataRepository.saveAll(salaryDataList);
    }

    public List<SalaryData> getAllSalaryData() {
        return salaryDataRepository.findAll();
    }

    public List<Double> analyze() {
        return List.of(1.0,2.0);
    }
}
