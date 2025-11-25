package com.example.forms_collect.repository;

import com.example.forms_collect.entity.Evocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvocationRepository extends CrudRepository<Evocation,Long> {
}
