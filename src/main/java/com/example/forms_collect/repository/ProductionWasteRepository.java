package com.example.forms_collect.repository;

import com.example.forms_collect.entity.ProductionWaste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionWasteRepository extends CrudRepository<ProductionWaste, Long> {
}
