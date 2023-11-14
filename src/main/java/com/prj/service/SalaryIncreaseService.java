package com.prj.service;

import com.prj.entity.SalaryIncrease;
import com.prj.repository.SalaryIncreaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SalaryIncreaseService {
    @Autowired
    private SalaryIncreaseRepository salaryIncreaseRepository;

    public void addOrUpdateSalaryIncrease(SalaryIncrease salaryIncrease) {
        salaryIncreaseRepository.save(salaryIncrease);
    }

    public List<SalaryIncrease> getAllSalaryIncrease() {
        return salaryIncreaseRepository.findAll();
    }

    public List<SalaryIncrease> getSalaryIncreaseByEmployeeId(String employeeID) {
        return salaryIncreaseRepository.findAllByEmployeeID(employeeID);
    }

    public List<SalaryIncrease> getSalaryIncreaseByDateRange(Instant startDate, Instant endDate) {
        return salaryIncreaseRepository.findAllByDatetimeGreaterThanEqualAndDatetimeLessThanEqual(startDate, endDate);
    }

    public SalaryIncrease getSalaryIncreaseById(String id) {
        return salaryIncreaseRepository.findById(id).orElse(null);
    }

    public void deleteSalaryIncreaseById(String id) {
        salaryIncreaseRepository.deleteById(id);
    }
}
