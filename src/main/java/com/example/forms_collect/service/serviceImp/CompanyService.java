package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.entity.Company;
import com.example.forms_collect.mapper.IMapperCompany;
import com.example.forms_collect.repository.ICompanyRepository;
import com.example.forms_collect.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private IMapperCompany mapperCompany;
    @Override
    public CompanyDto saveCompany(CompanyDto companyDto) {
        Company company = mapperCompany.toEntity(companyDto); // DTO → Entity
        Company saved = companyRepository.save(company);
        return mapperCompany.toDto(saved);
    }
}
