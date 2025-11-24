package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.VehicleDto;
import com.example.forms_collect.entity.Vehicle;
import com.example.forms_collect.entity.VehicleMonthlyData;
import com.example.forms_collect.mapper.IVehicleMapper;
import com.example.forms_collect.mapper.IVehicleMonthlyDataMapper;
import com.example.forms_collect.repository.IVehicleRepository;
import com.example.forms_collect.service.IVehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;
    private final IVehicleMapper vehicleMapper;
    private final IVehicleMonthlyDataMapper vehicleMonthlyDataMapper;

    public VehicleService(IVehicleRepository vehicleRepository,
                          IVehicleMapper vehicleMapper,
                          IVehicleMonthlyDataMapper vehicleMonthlyDataMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.vehicleMonthlyDataMapper = vehicleMonthlyDataMapper;
    }

    @Override
    @Transactional
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDto);

        // Gestion des données mensuelles
        if (vehicleDto.isMonthlyMonitoring() && vehicleDto.getMonthlyData() != null) {
            List<VehicleMonthlyData> monthlyEntities = vehicleMonthlyDataMapper.toEntity(vehicleDto.getMonthlyData());
            for (VehicleMonthlyData m : monthlyEntities) {
                m.setVehicle(vehicle);
            }
            vehicle.setMonthlyData(monthlyEntities);
        }

        Vehicle saved = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(saved);
    }
}