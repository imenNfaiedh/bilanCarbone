package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackagingMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packagingId;

    private String typeEmballage;

    private Double quantiteTonne;

    private String destination; // recyclage, incinération,

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
