package com.prj.repository;

import com.prj.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByIdContainingOrNameContainingOrDeptContainingOrPositionContaining(String id, String name, String dept, String position);
}
