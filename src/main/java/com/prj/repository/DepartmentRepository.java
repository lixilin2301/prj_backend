package com.prj.repository;

import com.prj.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByIdContainingOrNameContainingOrManagerContaining(String id, String name, String manager);
}
