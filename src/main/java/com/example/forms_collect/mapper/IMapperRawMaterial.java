package com.example.forms_collect.mapper;



import com.example.forms_collect.dto.RawMaterialDto;
import com.example.forms_collect.entity.RawMaterial;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapperRawMaterial {

    RawMaterialDto toDto(RawMaterial rawMaterial);
    List<RawMaterialDto> toDto(List<RawMaterial> rawMaterialList);

    RawMaterial toEntity(RawMaterialDto rawMaterialDto);
    List<RawMaterial> toEntity(List<RawMaterialDto> rawMaterialDtos);
}

