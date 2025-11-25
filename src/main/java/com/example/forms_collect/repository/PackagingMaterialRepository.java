package com.example.forms_collect.repository;

import com.example.forms_collect.entity.PackagingMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingMaterialRepository extends CrudRepository<PackagingMaterial, Long> {
}
