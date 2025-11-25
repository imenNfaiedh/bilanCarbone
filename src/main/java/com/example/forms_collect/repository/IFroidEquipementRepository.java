package com.example.forms_collect.repository;

import com.example.forms_collect.entity.FroidEquipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFroidEquipementRepository extends JpaRepository<FroidEquipement, Long> {
}