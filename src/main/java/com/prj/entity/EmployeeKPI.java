package com.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_kpi")
public class EmployeeKPI {
    @Id
    @Column
    private String id;

    @Column(name = "employeeID")
    private String employeeID;

    @Column
    private String leader;

    @Column
    private String kpi;

    @Column
    private String comments;

    @Column(name = "check_date")
    private Date checkDate;
}
