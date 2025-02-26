package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "DEPARTMENTS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "departments_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 50)
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_seq")
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME", unique = true)
    private String departmentName;

    @Column(name = "MANAGER_ID")
    private Long managerId;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    // Constructors, getters, and setters
}
