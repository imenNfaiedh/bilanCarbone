package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.dto.VehicleDto;
import com.example.forms_collect.service.IVehicleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;
    public VehicleController(IVehicleService vehicleService)
    {
        this.vehicleService=vehicleService;
    }

    @PostMapping
    public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.saveVehicle(vehicleDto);
    }
}
