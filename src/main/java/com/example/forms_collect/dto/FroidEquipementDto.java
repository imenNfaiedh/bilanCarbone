package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FroidEquipementDto {

    private Long id;
    private String siteZone;
    private Double puissance;
    private Double chargeNominaleKg;
    private String fluide;
    private Double rechargesKg;
    private Integer nbInterventions;
    private String sourceDonnees;
}
