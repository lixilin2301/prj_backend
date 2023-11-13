package com.prj.service;

import com.prj.entity.Employee;
import com.prj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> searchEmployees(String key) {
        return employeeRepository.findByIdContainingOrNameContainingOrDeptContainingOrPositionContaining(key, key, key, key);
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    public void deleteEmployeeByIdList(List<String> idList) {
        employeeRepository.deleteAllById(idList);
    }
}
