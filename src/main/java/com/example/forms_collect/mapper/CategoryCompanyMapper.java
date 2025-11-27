package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CategoryCompanyDTO;
import com.example.forms_collect.dto.CategoryCompanyRequestDTO;
import com.example.forms_collect.entity.CategoryCompany;
import org.springframework.stereotype.Component;

@Component
public class CategoryCompanyMapper {

    public CategoryCompanyDTO toDTO(CategoryCompany categoryCompany) {
        if (categoryCompany == null) {
            return null;
        }

        CategoryCompanyDTO dto = new CategoryCompanyDTO();
        dto.setCategoryId(categoryCompany.getCategoryId());
        dto.setName(categoryCompany.getName());
        dto.setDescription(categoryCompany.getDescription());

        return dto;
    }

    public CategoryCompany toEntity(CategoryCompanyRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        CategoryCompany categoryCompany = new CategoryCompany();
        categoryCompany.setName(requestDTO.getName());
        categoryCompany.setDescription(requestDTO.getDescription());
        return categoryCompany;
    }

    public void updateEntityFromDTO(CategoryCompanyRequestDTO requestDTO, CategoryCompany categoryCompany) {
        if (requestDTO == null || categoryCompany == null) {
            return;
        }

        categoryCompany.setName(requestDTO.getName());
        categoryCompany.setDescription(requestDTO.getDescription());
    }
}