package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.WaterSupplyDto;
import com.example.forms_collect.entity.WaterSupply;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapperWaterSupply {

    WaterSupplyDto toDto(WaterSupply waterSupply);
    List<WaterSupplyDto> toDto(List<WaterSupply> supplies);

    WaterSupply toEntity(WaterSupplyDto dto);
    List<WaterSupply> toEntity(List<WaterSupplyDto> dtos);
}
