package com.prj.controller;

import com.prj.entity.EmployeeKPI;
import com.prj.service.EmployeeKPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/employeeKPI")
public class EmployeeKPIController {

    @Autowired
    EmployeeKPIService employeeKPIService;

    @GetMapping(path = "/{employeeID}")
    public List<EmployeeKPI> getEmployeeKPIByEmployeeId(@PathVariable String employeeID) {
        return employeeKPIService.getEmployeeKPIByEmployeeID(employeeID);
    }

    @PostMapping(path = "/{employeeID}")
    public void saveEmployeeKPI(@PathVariable String employeeID, @RequestBody EmployeeKPI employeeKPI) {
        employeeKPI.setEmployeeID(employeeID);
        employeeKPI.setId(UUID.randomUUID().toString());
        employeeKPI.setCheckDate(new Date());
        employeeKPIService.addOrUpdateEmployeeKPI(employeeKPI);
    }
}
