package com.prj.controller;

import com.prj.entity.Employee;
import com.prj.entity.SalaryIncrease;
import com.prj.service.EmployeeService;
import com.prj.service.SalaryIncreaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryIncreaseService salaryIncreaseService;


    @GetMapping(path = "/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/search")
    public List<Employee> searchEmployees(@RequestParam String key) {
        return employeeService.searchEmployees(key);
    }

    @PostMapping(path = "/")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.addOrUpdateEmployee(employee);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @DeleteMapping(path = "/")
    public void deleteEmployees(@RequestBody List<String> id) {
        employeeService.deleteEmployeeByIdList(id);
    }

    @PostMapping(path = "{employeeId}/increaseSalary/")
    public void saveSalaryIncrease(@PathVariable String employeeId, @RequestBody SalaryIncrease salaryIncrease) {
        salaryIncrease.setEmployeeID(employeeId);
        salaryIncrease.setId(UUID.randomUUID().toString());
        salaryIncrease.setDatetime(Instant.now());
        salaryIncreaseService.addOrUpdateSalaryIncrease(salaryIncrease);
    }

    @GetMapping(path = "{employeeId}/increaseSalary/")
    public List<SalaryIncrease> saveEmployee(@PathVariable String employeeId) {
        return salaryIncreaseService.getSalaryIncreaseByEmployeeId(employeeId);
    }

    @GetMapping(path = "{employeeId}/increaseSalary/search")
    public List<SalaryIncrease> saveEmployee(@RequestParam Instant startDate,@RequestParam Instant endDate) {
        return salaryIncreaseService.getSalaryIncreaseByDateRange(startDate, endDate);
    }
}
