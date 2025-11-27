package com.example.forms_collect.repository;

import com.example.forms_collect.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends CrudRepository <Company,Long> {
    List<Company> findByCategoryCompanyCategoryId(Long categoryId);

    boolean existsByNameAndCategoryCompanyCategoryId(String name, Long categoryId);

    @Query("SELECT c FROM Company c WHERE c.categoryCompany.categoryId = :categoryId")
    List<Company> findAllByCategoryId(@Param("categoryId") Long categoryId);

    List<Company> findByNameContainingIgnoreCase(String name);
}
