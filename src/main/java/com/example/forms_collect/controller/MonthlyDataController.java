package com.example.forms_collect.controller;

import com.example.forms_collect.dto.MonthlyDataDto;
import com.example.forms_collect.entity.MonthlyData;
import com.example.forms_collect.service.IMonthlyDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monthly-data")
public class MonthlyDataController {

    private final IMonthlyDataService service;

    public MonthlyDataController(IMonthlyDataService service) {
        this.service = service;
    }

    @PostMapping
    public void saveMonthlyData(@RequestBody List<MonthlyDataDto> monthlyData) {
        service.saveMonthlyData(monthlyData);
    }

//    @GetMapping("/{combustibleId}")
//    public List<MonthlyData> getMonthlyData(@PathVariable Long combustibleId) {
//        return service.getMonthlyDataByCombustible(combustibleId);
//    }
}
