package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "REGIONS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGION_ID")
    private Long regionId;
    @Column(name = "REGION_NAME", unique = true)
    private String regionName;

    // Constructors, getters, and setters
}
