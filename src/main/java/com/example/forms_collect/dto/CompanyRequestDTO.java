package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequestDTO {
    private String name;
    private String website;
    private Integer staffCount;
    private Double revenue;
    private Double officeArea;
    private Double productionArea;
    private Integer year;
    private String manager;
    private Long categoryCompanyId;
}