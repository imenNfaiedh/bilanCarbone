package com.example.forms_collect.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialDto {

    private Long rawMaterialId;
    private String nature;
    private String composition;
    private Double annualQuantity;
    private String unit;
    private String provenance;
    private Double recycledContent;
    private String method;
}
