package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;


    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto savedCompany = companyService.saveCompany(companyDto);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }
}
