package com.example.forms_collect.service;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyFullDto;

public interface ICompanyService {
     CompanyFullDto saveCompanyFull(CompanyFullDto dto);
}
