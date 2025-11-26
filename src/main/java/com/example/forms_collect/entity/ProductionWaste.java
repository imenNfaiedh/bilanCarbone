package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wasteId;

    private String typeDechet;

    private Double quantiteTonne;

    private String destination; // recyclage, incinération, décharge

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

