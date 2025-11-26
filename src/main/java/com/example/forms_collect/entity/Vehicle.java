package com.example.forms_collect.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long vehicleId;

    private String vehicleType;
    private Integer numberOfVehicles;
    private Double annualConsumption;
    private String fuelType;
    private Double annualKilometrage;
    private String dataAcquisitionMethod;
    private boolean monthlyMonitoring;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleMonthlyData> monthlyData = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
