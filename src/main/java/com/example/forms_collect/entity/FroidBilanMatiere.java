package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FroidBilanMatiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fluide;
    private Double rechargeAnnuelleKg;
    private String justificatifs;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
