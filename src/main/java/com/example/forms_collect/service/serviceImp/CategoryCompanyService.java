package com.example.forms_collect.service.serviceImp;


import com.example.forms_collect.dto.CategoryCompanyDTO;
import com.example.forms_collect.dto.CategoryCompanyRequestDTO;
import com.example.forms_collect.entity.CategoryCompany;
import com.example.forms_collect.mapper.CategoryCompanyMapper;
import com.example.forms_collect.repository.CategoryCompanyRepository;
import com.example.forms_collect.service.ICategoryCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryCompanyService implements ICategoryCompanyService {

    private final CategoryCompanyRepository categoryCompanyRepository;
    private final CategoryCompanyMapper categoryCompanyMapper;

    @Override
    public CategoryCompanyDTO createCategory(CategoryCompanyRequestDTO requestDTO) {
        if (categoryCompanyRepository.existsByName(requestDTO.getName())) {
            throw new RuntimeException("Une catégorie avec le nom '" + requestDTO.getName() + "' existe déjà");
        }

        CategoryCompany categoryCompany = categoryCompanyMapper.toEntity(requestDTO);
        CategoryCompany savedCategory = categoryCompanyRepository.save(categoryCompany);
        return categoryCompanyMapper.toDTO(savedCategory);
    }

    @Override
    public CategoryCompanyDTO getCategoryById(Long id) {
        CategoryCompany categoryCompany = categoryCompanyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + id));
        return categoryCompanyMapper.toDTO(categoryCompany);
    }

    @Override
    public List<CategoryCompanyDTO> getAllCategories() {
        return categoryCompanyRepository.findAll()
                .stream()
                .map(categoryCompanyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryCompanyDTO updateCategory(Long id, CategoryCompanyRequestDTO requestDTO) {
        CategoryCompany existingCategory = categoryCompanyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + id));

        // Vérifier si le nom existe déjà pour une autre catégorie
        if (!existingCategory.getName().equals(requestDTO.getName()) &&
                categoryCompanyRepository.existsByName(requestDTO.getName())) {
            throw new RuntimeException("Une catégorie avec le nom '" + requestDTO.getName() + "' existe déjà");
        }

        categoryCompanyMapper.updateEntityFromDTO(requestDTO, existingCategory);
        CategoryCompany updatedCategory = categoryCompanyRepository.save(existingCategory);
        return categoryCompanyMapper.toDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryCompany categoryCompany = categoryCompanyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + id));
        categoryCompanyRepository.delete(categoryCompany);
    }


    @Override
    public boolean existsByName(String name) {
        return categoryCompanyRepository.existsByName(name);
    }

}