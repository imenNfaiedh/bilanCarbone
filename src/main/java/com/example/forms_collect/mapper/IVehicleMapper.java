package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.VehicleDto;
import com.example.forms_collect.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IVehicleMonthlyDataMapper.class})
public interface IVehicleMapper {

    VehicleDto toDto(Vehicle entity);

    @Mapping(target = "monthlyData", ignore = true) // gestion dans le service pour lier VehicleMonthlyData
    Vehicle toEntity(VehicleDto dto);
}
