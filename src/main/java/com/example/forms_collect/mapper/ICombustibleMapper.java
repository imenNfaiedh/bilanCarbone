package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.entity.Combustible;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICombustibleMonthlyDataMapper.class})
public interface ICombustibleMapper {


    @Mapping(source = "donneesMensuelles", target = "monthlyData")
    CombustibleDto toDto(Combustible entity);

    @Mapping(target = "donneesMensuelles", ignore = true) // géré dans le service
    Combustible toEntity(CombustibleDto dto);
}
