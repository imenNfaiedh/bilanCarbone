package com.example.forms_collect.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long companyId;
    private String name;
    private String website;
    private Integer staffCount;
    private Double revenue;
    private Double officeArea; // Surface bureaux
    private Double productionArea;
    private Integer year;
    private String manager;
}
