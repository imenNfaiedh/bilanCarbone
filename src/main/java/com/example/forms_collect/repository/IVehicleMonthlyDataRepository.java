package com.example.forms_collect.repository;

import com.example.forms_collect.entity.VehicleMonthlyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVehicleMonthlyDataRepository extends JpaRepository<VehicleMonthlyData, Long> {
    List<VehicleMonthlyData> findByVehicle_VehicleId(Long vehicleId);
    void deleteByVehicle_VehicleId(Long vehicleId);
}
