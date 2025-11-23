package com.example.forms_collect.repository;

import com.example.forms_collect.entity.MonthlyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthlyDataRepository extends JpaRepository<MonthlyData, Long> {
    List<MonthlyData> findByCombustible_CombustibleId(Long combustibleId);
    void deleteByCombustible_CombustibleId(Long combustibleId);

}
