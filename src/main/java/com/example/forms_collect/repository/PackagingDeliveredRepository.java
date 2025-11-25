package com.example.forms_collect.repository;

import com.example.forms_collect.entity.PackagingDelivered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingDeliveredRepository extends CrudRepository<PackagingDelivered, Long> {
}
