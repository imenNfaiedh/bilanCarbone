package com.example.forms_collect.service;

import com.example.forms_collect.dto.VehicleDto;
import com.example.forms_collect.entity.VehicleMonthlyData;

import java.util.List;

public interface IVehicleService {
    public VehicleDto saveVehicle(VehicleDto dto);
}
