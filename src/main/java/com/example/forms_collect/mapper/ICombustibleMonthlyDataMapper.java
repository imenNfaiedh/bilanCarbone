package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.MonthlyDataDto;
import com.example.forms_collect.entity.MonthlyData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICombustibleMonthlyDataMapper {

    MonthlyDataDto toDto(MonthlyData entity);

    List<MonthlyDataDto> toDto(List<MonthlyData> entities);

    MonthlyData toEntity(MonthlyDataDto dto);

    List<MonthlyData> toEntity(List<MonthlyDataDto> dtos);
}
