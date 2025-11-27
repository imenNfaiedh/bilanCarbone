package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CategoryCompanyDTO;
import com.example.forms_collect.dto.CategoryCompanyRequestDTO;
import com.example.forms_collect.service.ICategoryCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryCompanyController {

    private final ICategoryCompanyService categoryCompanyService;

    @PostMapping
    public ResponseEntity<CategoryCompanyDTO> createCategory( @RequestBody CategoryCompanyRequestDTO requestDTO) {
        CategoryCompanyDTO createdCategory = categoryCompanyService.createCategory(requestDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryCompanyDTO>> getAllCategories() {
        List<CategoryCompanyDTO> categories = categoryCompanyService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryCompanyDTO> getCategoryById(@PathVariable Long id) {
        CategoryCompanyDTO category = categoryCompanyService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryCompanyDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryCompanyRequestDTO requestDTO) {
        CategoryCompanyDTO updatedCategory = categoryCompanyService.updateCategory(id, requestDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryCompanyService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkCategoryExistsByName(@RequestParam String name) {
        boolean exists = categoryCompanyService.existsByName(name);
        return ResponseEntity.ok(exists);
    }
}