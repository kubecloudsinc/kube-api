package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "AUTO_TOOL_USER")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRST_NAME", unique = true)
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ORGANIZATION")
    private String organization;
    @Column(name = "ADDED_DATE")
    private Date addedDate;
    @Column(name = "TOTAL_HITS")
    private Long  totalHits;
    // Constructors, getters, and setters
}
