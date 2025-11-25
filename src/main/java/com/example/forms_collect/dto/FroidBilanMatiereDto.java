package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FroidBilanMatiereDto {
    private Long id;
    private String fluide;
    private Double rechargeAnnuelleKg;
    private String justificatifs;
}
