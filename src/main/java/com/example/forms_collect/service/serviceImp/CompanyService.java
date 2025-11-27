package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.CompanyRequestDTO;
import com.example.forms_collect.entity.Company;
import com.example.forms_collect.entity.CategoryCompany;
import com.example.forms_collect.mapper.CompanyMapper;
import com.example.forms_collect.repository.CategoryCompanyRepository;
import com.example.forms_collect.repository.ICompanyRepository;
import com.example.forms_collect.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {

    private final ICompanyRepository companyRepository;
    private final CategoryCompanyRepository categoryCompanyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyDto saveCompany(CompanyRequestDTO companyRequestDTO) {
        CategoryCompany categoryCompany = categoryCompanyRepository.findById(companyRequestDTO.getCategoryCompanyId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + companyRequestDTO.getCategoryCompanyId()));

        Company company = companyMapper.toEntity(companyRequestDTO, categoryCompany);
        Company saved = companyRepository.save(company);
        return companyMapper.toDto(saved);
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID: " + id));
        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);

        return companies.stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto updateCompany(Long id, CompanyRequestDTO companyRequestDTO) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID: " + id));

        CategoryCompany categoryCompany = categoryCompanyRepository.findById(companyRequestDTO.getCategoryCompanyId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + companyRequestDTO.getCategoryCompanyId()));

        companyMapper.updateEntityFromDTO(companyRequestDTO, existingCompany, categoryCompany);
        Company updatedCompany = companyRepository.save(existingCompany);
        return companyMapper.toDto(updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID: " + id));
        companyRepository.delete(company);
    }

    @Override
    public List<CompanyDto> getCompaniesByCategoryId(Long categoryId) {
        return companyRepository.findByCategoryCompanyCategoryId(categoryId)
                .stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompanyDto> searchCompaniesByName(String name) {
        return companyRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }
}