package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyRequestDTO;
import com.example.forms_collect.entity.Company;
import com.example.forms_collect.entity.CategoryCompany;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDto toDto(Company company) {
        if (company == null) {
            return null;
        }

        CompanyDto dto = new CompanyDto();
        dto.setCompanyId(company.getCompanyId());
        dto.setName(company.getName());
        dto.setWebsite(company.getWebsite());
        dto.setStaffCount(company.getStaffCount());
        dto.setRevenue(company.getRevenue());
        dto.setOfficeArea(company.getOfficeArea());
        dto.setProductionArea(company.getProductionArea());
        dto.setYear(company.getYear());
        dto.setManager(company.getManager());

        if (company.getCategoryCompany() != null) {
            dto.setCategoryCompanyId(company.getCategoryCompany().getCategoryId());
        }

        return dto;
    }

    public Company toEntity(CompanyRequestDTO requestDTO, CategoryCompany categoryCompany) {
        if (requestDTO == null) {
            return null;
        }

        Company company = new Company();
        company.setName(requestDTO.getName());
        company.setWebsite(requestDTO.getWebsite());
        company.setStaffCount(requestDTO.getStaffCount());
        company.setRevenue(requestDTO.getRevenue());
        company.setOfficeArea(requestDTO.getOfficeArea());
        company.setProductionArea(requestDTO.getProductionArea());
        company.setYear(requestDTO.getYear());
        company.setManager(requestDTO.getManager());
        company.setCategoryCompany(categoryCompany);

        return company;
    }

    public void updateEntityFromDTO(CompanyRequestDTO requestDTO, Company company, CategoryCompany categoryCompany) {
        if (requestDTO == null || company == null) {
            return;
        }

        company.setName(requestDTO.getName());
        company.setWebsite(requestDTO.getWebsite());
        company.setStaffCount(requestDTO.getStaffCount());
        company.setRevenue(requestDTO.getRevenue());
        company.setOfficeArea(requestDTO.getOfficeArea());
        company.setProductionArea(requestDTO.getProductionArea());
        company.setYear(requestDTO.getYear());
        company.setManager(requestDTO.getManager());
        company.setCategoryCompany(categoryCompany);
    }
}