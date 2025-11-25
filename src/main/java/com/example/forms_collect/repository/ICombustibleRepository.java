package com.example.forms_collect.repository;

import com.example.forms_collect.entity.Combustible;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICombustibleRepository extends CrudRepository<Combustible,Long> {
}
