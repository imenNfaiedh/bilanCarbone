package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.ProductionWasteDto;
import com.example.forms_collect.entity.ProductionWaste;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductionWasteMapper {
    ProductionWasteDto toDto(ProductionWaste entity);
    ProductionWaste toEntity(ProductionWasteDto dto);

    List<ProductionWasteDto> toDto(List<ProductionWaste> list);
    List<ProductionWaste> toEntity(List<ProductionWasteDto> list);
}