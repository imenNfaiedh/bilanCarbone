package com.example.forms_collect.repository;


import com.example.forms_collect.entity.CategoryCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryCompanyRepository extends JpaRepository<CategoryCompany, Long> {


    boolean existsByName(String name);


}
