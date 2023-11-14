package com.prj.controller;

import com.prj.entity.Department;
import com.prj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping(path = "/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping(path = "/{id}")
    public Department getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping(path = "/search")
    public List<Department> searchDepartments(@RequestParam String key) {
        return departmentService.searchDepartments(key);
    }

    @PostMapping(path = "/")
    public void saveDepartment(@RequestBody Department department) {
        departmentService.addOrUpdateDepartment(department);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDepartmentById(@PathVariable String id) {
        departmentService.deleteDepartmentById(id);
    }

    @DeleteMapping(path = "/")
    public void deleteDepartments(@RequestBody List<String> id) {
        departmentService.deleteDepartmentByIdList(id);
    }

}
