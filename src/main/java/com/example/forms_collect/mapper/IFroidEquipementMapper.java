package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.FroidEquipementDto;
import com.example.forms_collect.entity.FroidEquipement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFroidEquipementMapper {

    FroidEquipementDto toDto(FroidEquipement equipement);
    List<FroidEquipementDto> toDto(List<FroidEquipement> equipements);

    FroidEquipement toEntity(FroidEquipementDto dto);
    List<FroidEquipement> toEntity(List<FroidEquipementDto> dtos);
}
