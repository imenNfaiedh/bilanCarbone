package com.example.forms_collect.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterSupplyDto {

    private Long waterSupplyId;
    private String source;
    private Double annualVolume;
    private String pretreatment;
    private String usagePrincipal;
    private String acquisitionMethod;
    private String discharge;
    private Boolean monthlyTracking;
}
