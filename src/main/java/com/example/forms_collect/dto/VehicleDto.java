package com.example.forms_collect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long vehicleId;

    private String vehicleType;
    private Integer numberOfVehicles;
    private Double annualConsumption;
    private String fuelType;
    private Double annualKilometrage;
    private String dataAcquisitionMethod;
    private boolean monthlyMonitoring;
    private List<VehicleMonthlyDataDto> monthlyData;
}
