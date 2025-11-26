package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "raw_material")
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rawMaterialId;

    private String nature;
    private String composition;
    private Double annualQuantity;
    private String unit;
    private String provenance;
    private Double recycledContent;
    private String method;

    // 3.7 A. Matières premières (hors eau)

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
