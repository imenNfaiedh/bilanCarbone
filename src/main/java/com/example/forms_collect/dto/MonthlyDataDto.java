package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyDataDto {
    private Long combustibleId;
    private Map<String, Double> monthlyData; // {"Janvier": 100, "Février": 120, ...}
}

