package com.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "salary_increase")
public class SalaryIncrease {
    @Id
    @Column
    private String id;

    @Column(name = "employeeID")
    String employeeID;

    @Column(name = "salary_increase")
    private float salaryIncrease;

    @Column
    private String reviewer;

    @Column
    private String comment;

    @Column
    private Instant datetime;
}
