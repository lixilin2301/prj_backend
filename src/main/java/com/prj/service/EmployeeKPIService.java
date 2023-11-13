package com.prj.service;

import com.prj.entity.EmployeeKPI;
import com.prj.repository.EmployeeKPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeKPIService {
    @Autowired
    private EmployeeKPIRepository employeeKPIRepository;

    public void addOrUpdateEmployeeKPI(EmployeeKPI employeeKPI) {
        employeeKPIRepository.save(employeeKPI);
    }

    public List<EmployeeKPI> getEmployeeKPIByEmployeeID(String employeeID) {
        return employeeKPIRepository.findAllByEmployeeID(employeeID);
    }
}
