package com.prj.repository;

import com.prj.entity.SalaryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDataRepository extends JpaRepository<SalaryData, String> {
}
