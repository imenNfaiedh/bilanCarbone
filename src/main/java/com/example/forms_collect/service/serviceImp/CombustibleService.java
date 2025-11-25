package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.entity.Combustible;
import com.example.forms_collect.entity.MonthlyData;
import com.example.forms_collect.mapper.ICombustibleMapper;
import com.example.forms_collect.mapper.ICombustibleMonthlyDataMapper;
import com.example.forms_collect.repository.ICombustibleRepository;
import com.example.forms_collect.service.ICombustibleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CombustibleService implements ICombustibleService {

    private final ICombustibleRepository combustibleRepository;
    private final ICombustibleMapper combustibleMapper;
    private final ICombustibleMonthlyDataMapper combustibleMonthlyDataMapper;

    public CombustibleService(ICombustibleRepository combustibleRepository,
                              ICombustibleMapper combustibleMapper,
                              ICombustibleMonthlyDataMapper combustibleMonthlyDataMapper) {
        this.combustibleRepository = combustibleRepository;
        this.combustibleMapper = combustibleMapper;
        this.combustibleMonthlyDataMapper = combustibleMonthlyDataMapper;
    }

    @Override
    @Transactional
    public CombustibleDto saveCombustible(CombustibleDto combustibleDto) {

        // 1) Convertir DTO → Entité
        Combustible combustible = combustibleMapper.toEntity(combustibleDto);

        // 2) Gérer les données mensuelles
        if (combustibleDto.isMonthlyMonitoring() && combustibleDto.getMonthlyData() != null) {
            List<MonthlyData> monthlyEntities =
                    combustibleMonthlyDataMapper.toEntity(combustibleDto.getMonthlyData());

            for (MonthlyData md : monthlyEntities) {
                md.setCombustible(combustible); // association
            }

            combustible.setDonneesMensuelles(monthlyEntities);
        }


        Combustible saved = combustibleRepository.save(combustible);


        return combustibleMapper.toDto(saved);
    }
}