package com.prj.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dept")
public class Department {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String manager;
}
