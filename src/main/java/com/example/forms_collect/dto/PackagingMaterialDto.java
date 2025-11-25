package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackagingMaterialDto {
    private Long packagingId;
    private String typeEmballage;
    private Double quantiteTonne;
    private String destination;
}