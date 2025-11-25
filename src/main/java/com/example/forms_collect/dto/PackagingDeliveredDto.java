package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackagingDeliveredDto {
    private Long packagingDeliveredId;
    private String typeEmballage;
    private Double quantiteTonne;
}
