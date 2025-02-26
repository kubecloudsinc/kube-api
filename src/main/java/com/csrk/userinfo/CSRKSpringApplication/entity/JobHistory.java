package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "JOB_HISTORY")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_HISTORY_ID")
    private Long jobHistoryId;
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    // Constructors, getters, and setters
}
