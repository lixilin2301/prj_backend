package com.prj.repository;

import com.prj.entity.EmployeeKPI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeKPIRepository extends JpaRepository<EmployeeKPI, String> {
    List<EmployeeKPI> findAllByEmployeeID(String employeeID);
}
