package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryCompanyRequestDTO {
    private String name;
    private String description;
}