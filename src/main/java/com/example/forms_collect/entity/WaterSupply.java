package com.example.forms_collect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "water_supply")
public class WaterSupply {
    //3.7 B. Eau - Approvisionnement et traitement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waterSupplyId;

    private String source;
    private Double annualVolume;
    private String pretreatment;
    private String usagePrincipal;
    private String acquisitionMethod;
    private String discharge;
    private Boolean monthlyTracking;

}
