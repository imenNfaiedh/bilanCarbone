package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.VehicleMonthlyDataDto;
import com.example.forms_collect.entity.VehicleMonthlyData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVehicleMonthlyDataMapper {

    VehicleMonthlyDataDto toDto(VehicleMonthlyData entity);

    List<VehicleMonthlyDataDto> toDto(List<VehicleMonthlyData> entities);

    VehicleMonthlyData toEntity(VehicleMonthlyDataDto dto);

    List<VehicleMonthlyData> toEntity(List<VehicleMonthlyDataDto> dtos);
}

