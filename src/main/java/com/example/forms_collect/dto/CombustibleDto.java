package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombustibleDto {
    private Long combustibleId;
    private String type;
    private String unite;
    private Double annualQuantity;
    private String dataAcquisitionMethod;
    private boolean monthlyMonitoring;

}
