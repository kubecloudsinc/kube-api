package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "EMPLOYEES")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "EMPLOYEES_SEQ", sequenceName = "EMPLOYEES_SEQ", allocationSize = 50)
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQ")
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "FIRST_NAME", unique = true)
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;
    @Column(name = "HIRE_DATE", unique = true)
    private LocalDate hireDate;
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "SALARY")
    private Long salary;
    @Column(name = "COMMISSION_PCT")
    private Long commissionPct;
    @Column(name = "MANAGER_ID")
    private Long managerId;
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
}
