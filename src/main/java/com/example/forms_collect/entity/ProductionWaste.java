package com.example.forms_collect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}

