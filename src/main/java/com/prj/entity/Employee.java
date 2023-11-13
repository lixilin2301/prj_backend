package com.prj.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String dept;

    @Column
    private String position;

    @Column
    private float salary;
}
