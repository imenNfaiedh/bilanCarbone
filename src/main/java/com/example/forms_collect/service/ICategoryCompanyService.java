package com.example.forms_collect.service;


import com.example.forms_collect.dto.CategoryCompanyDTO;
import com.example.forms_collect.dto.CategoryCompanyRequestDTO;
import java.util.List;

public interface ICategoryCompanyService {

    CategoryCompanyDTO createCategory(CategoryCompanyRequestDTO requestDTO);

    CategoryCompanyDTO getCategoryById(Long id);

    List<CategoryCompanyDTO> getAllCategories();

    CategoryCompanyDTO updateCategory(Long id, CategoryCompanyRequestDTO requestDTO);

    void deleteCategory(Long id);


    boolean existsByName(String name);

}