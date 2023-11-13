package com.prj.controller;

import com.prj.entity.EmployeeKPI;
import com.prj.entity.SalaryData;
import com.prj.service.EmployeeKPIService;
import com.prj.service.SalaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/salaryData")
public class SalaryDataController {

    @Autowired
    SalaryDataService salaryDataService;

    @GetMapping(path = "/")
    public List<SalaryData> getAllSalaryData() {
        return salaryDataService.getAllSalaryData();
    }

    @GetMapping(path = "/analyze")
    public List<Double> analyzeSalaryData() {
        return salaryDataService.analyze();
    }

    @PostMapping(path = "/import")
    public void saveEmployeeKPI(@RequestBody List<SalaryData> salaryDataList) {
        salaryDataService.addAllSalaryData(salaryDataList);
    }
}
