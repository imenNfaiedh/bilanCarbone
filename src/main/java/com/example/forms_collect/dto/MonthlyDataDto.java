package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyDataDto {
    private Long id;
    private String mois;
    private Double quantite;
    private String type;



}

