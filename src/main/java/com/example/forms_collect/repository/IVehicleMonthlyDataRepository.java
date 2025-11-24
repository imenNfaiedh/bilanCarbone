package com.example.forms_collect.repository;

import com.example.forms_collect.entity.VehicleMonthlyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleMonthlyDataRepository extends JpaRepository<VehicleMonthlyData, Long> {
    List<VehicleMonthlyData> findByVehicle_VehicleId(Long vehicleId);
    void deleteByVehicle_VehicleId(Long vehicleId);
}
