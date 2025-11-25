package com.example.forms_collect.repository;

import com.example.forms_collect.entity.FroidBilanMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFroidBilanMatiereRepository extends JpaRepository<FroidBilanMatiere,Long> {
}
