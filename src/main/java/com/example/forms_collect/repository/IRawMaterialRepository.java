package com.example.forms_collect.repository;

import com.example.forms_collect.entity.RawMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRawMaterialRepository extends CrudRepository<RawMaterial, Long> {

}