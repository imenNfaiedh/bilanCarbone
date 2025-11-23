package com.example.forms_collect.service;

import com.example.forms_collect.dto.MonthlyDataDto;
import com.example.forms_collect.entity.MonthlyData;

import java.util.List;

public interface IMonthlyDataService {
    public void saveMonthlyData(List<MonthlyDataDto> monthlyDataDtos);
    public List<MonthlyData> getMonthlyDataByCombustible(Long combustibleId);

}
