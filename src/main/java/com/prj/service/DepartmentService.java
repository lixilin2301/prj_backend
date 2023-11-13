package com.prj.service;

import com.prj.entity.Department;
import com.prj.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addOrUpdateDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> searchDepartments(String key) {
        return departmentRepository.findByIdContainingOrNameContainingOrManagerContaining(key, key, key);
    }

    public void deleteDepartmentById(String id) {
        departmentRepository.deleteById(id);
    }

    public void deleteDepartmentByIdList(List<String> idList) {
        departmentRepository.deleteAllById(idList);
    }
}
