package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evocation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String strategy;

    @Column(columnDefinition = "TEXT")
    private String certifications;

    @Column(columnDefinition = "TEXT")
    private String suiviFlux;

    @Column(columnDefinition = "TEXT")
    private String product;

    @Column(columnDefinition = "TEXT")
    private String rse;

    @Column(columnDefinition = "TEXT")
    private String project;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

