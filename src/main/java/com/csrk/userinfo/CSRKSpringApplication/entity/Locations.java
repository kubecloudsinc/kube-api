package com.csrk.userinfo.CSRKSpringApplication.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

@Table(name = "LOCATIONS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "locations_seq", sequenceName = "LOCATIONS_SEQ", allocationSize = 50)
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_seq")
    @Column(name = "LOCATION_ID")
    private Long locationId;
    @Column(name = "STREET_ADDRESS", unique = true)
    private String streetAddress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "COUNTRY_ID")
    private String countryId;

    // Constructors, getters, and setters
}
