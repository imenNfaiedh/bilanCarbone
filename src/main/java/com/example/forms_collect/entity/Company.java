package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "staff_count")
    private Integer staffCount;

    @Column(name = "revenue")
    private Double revenue;

    @Column(name = "office_area")
    private Double officeArea; // Surface bureaux

    @Column(name = "production_area")
    private Double productionArea;

    @Column(name = "year")
    private Integer year;

    @Column(name = "manager")
    private String manager;

}
