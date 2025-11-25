package com.example.forms_collect.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionWasteDto {
    private Long wasteId;
    private String typeDechet;
    private Double quantiteTonne;
    private String destination;
}

