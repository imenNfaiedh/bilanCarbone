package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvocationDto {

    private Long id;
    private String strategy;
    private String certifications;
    private String suiviFlux;
    private String product;
    private String rse;
    private String project;
}
