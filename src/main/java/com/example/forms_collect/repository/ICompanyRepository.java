package com.example.forms_collect.repository;

import com.example.forms_collect.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyRepository extends CrudRepository <Company,Long> {
}
