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

    public List<SalaryIncrease> getSalaryIncreaseByEmployeeId(String employeeID) {
        return salaryIncreaseRepository.findAllByEmployeeID(employeeID);
    }

    public List<SalaryIncrease> getSalaryIncreaseByDateRange(String employeeID, Instant startDate, Instant endDate) {
        return salaryIncreaseRepository.findAllByEmployeeIDAndDatetimeGreaterThanEqualAndDatetimeLessThanEqual(employeeID, startDate, endDate);
    }
}
