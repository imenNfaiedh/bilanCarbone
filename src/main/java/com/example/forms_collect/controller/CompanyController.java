package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyFullDto;
import com.example.forms_collect.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;
    @PostMapping("/save-full")
    public CompanyFullDto saveCompanyFull(@RequestBody CompanyFullDto dto) {
        System.out.println("CONTROLLER RECEIVED DTO = " + dto);
        return companyService.saveCompanyFull(dto);

    }



//    @PostMapping
//    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
//        CompanyDto savedCompany = companyService.saveCompany(companyDto);
//        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
//    }
}
