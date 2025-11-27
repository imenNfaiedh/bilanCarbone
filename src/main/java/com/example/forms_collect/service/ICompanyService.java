package com.example.forms_collect.service;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyRequestDTO;

import java.util.List;

public interface ICompanyService {
     CompanyDto saveCompany(CompanyRequestDTO companyRequestDTO);
     CompanyDto getCompanyById(Long id);
     List<CompanyDto> getAllCompanies();
     CompanyDto updateCompany(Long id, CompanyRequestDTO companyRequestDTO);
     void deleteCompany(Long id);
     List<CompanyDto> getCompaniesByCategoryId(Long categoryId);
     List<CompanyDto> searchCompaniesByName(String name);
}
