package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface IMapperCompany {
    CompanyDto toDto (Company company);
    List<CompanyDto> toDto (List<Company> companies);
    Company toEntity(CompanyDto companyDto);
    List<Company> toEntity (List<CompanyDto> companyDtos);

}
