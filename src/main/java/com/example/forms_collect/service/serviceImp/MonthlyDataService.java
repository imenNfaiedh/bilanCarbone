package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.MonthlyDataDto;
import com.example.forms_collect.repository.ICombustibleRepository;
import com.example.forms_collect.service.IMonthlyDataService;
import org.springframework.stereotype.Service;
import com.example.forms_collect.entity.Combustible;
import com.example.forms_collect.entity.MonthlyData;
import com.example.forms_collect.repository.MonthlyDataRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
//@Transactional

public class MonthlyDataService implements IMonthlyDataService {
    private final MonthlyDataRepository monthlyDataRepository;
    private final ICombustibleRepository combustibleRepository;

    public MonthlyDataService(MonthlyDataRepository monthlyDataRepository,
                              ICombustibleRepository combustibleRepository) {
        this.monthlyDataRepository = monthlyDataRepository;
        this.combustibleRepository = combustibleRepository;
    }

    public void saveMonthlyData(List<MonthlyDataDto> monthlyDataDtos) {
        for (MonthlyDataDto dto : monthlyDataDtos) {
            Combustible combustible = combustibleRepository.findById(dto.getCombustibleId())
                    .orElseThrow(() -> new RuntimeException("Combustible non trouvé"));
            // On supprime l'ancien contenu
            if (combustible.isMonthlyMonitoring()) {
            monthlyDataRepository.deleteByCombustible_CombustibleId(dto.getCombustibleId());

            for (Map.Entry<String, Double> entry : dto.getMonthlyData().entrySet()) {
                MonthlyData data = new MonthlyData();
                data.setCombustible(combustible);
                data.setMois(entry.getKey());
                data.setQuantite(entry.getValue());
                monthlyDataRepository.save(data);
            }
        }}
    }

    public List<MonthlyData> getMonthlyDataByCombustible(Long combustibleId) {
        return monthlyDataRepository.findByCombustible_CombustibleId(combustibleId);
    }
}

