package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryCompanyDTO {
    private Long categoryId;
    private String name;
    private String description;
    private List<CompanyDto> companies;
}