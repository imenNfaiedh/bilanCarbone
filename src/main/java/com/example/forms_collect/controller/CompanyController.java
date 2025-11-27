package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyRequestDTO;
import com.example.forms_collect.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany( @RequestBody CompanyRequestDTO requestDTO) {
        CompanyDto createdCompany = companyService.saveCompany(requestDTO);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        CompanyDto company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(
            @PathVariable Long id,
            @RequestBody CompanyRequestDTO requestDTO) {
        CompanyDto updatedCompany = companyService.updateCompany(id, requestDTO);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CompanyDto>> getCompaniesByCategory(@PathVariable Long categoryId) {
        List<CompanyDto> companies = companyService.getCompaniesByCategoryId(categoryId);
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CompanyDto>> searchCompaniesByName(@RequestParam String name) {
        List<CompanyDto> companies = companyService.searchCompaniesByName(name);
        return ResponseEntity.ok(companies);
    }
}