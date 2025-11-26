package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FroidEquipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siteZone;
    private Double puissance;             // kW/Ch/Btu
    private Double chargeNominaleKg;
    private String fluide;
    private Double rechargesKg;
    private Integer nbInterventions;
    private String sourceDonnees;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
