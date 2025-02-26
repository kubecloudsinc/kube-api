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
public class Countries {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "COUNTRY_ID")
    private Long countryId;
    @Column(name = "COUNTRY_NAME", unique = true)
    private String countryName;
    @Column(name = "REGION_ID")
    private Long regionId;

    // Constructors, getters, and setters
}
