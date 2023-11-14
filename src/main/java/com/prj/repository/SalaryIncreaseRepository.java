package com.prj.repository;

import com.prj.entity.Employee;
import com.prj.entity.SalaryIncrease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface SalaryIncreaseRepository extends JpaRepository<SalaryIncrease, String> {
    List<SalaryIncrease> findAllByEmployeeID(String employeeID);

    List<SalaryIncrease> findAllByDatetimeGreaterThanEqualAndDatetimeLessThanEqual(Instant startDate, Instant endDate);
}
