package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "JOBS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "JOB_TITLE", unique = true)
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private Long minSalary;
    @Column(name = "MAX_SALARY")
    private Long maxSalary;

    // Constructors, getters, and setters
}
