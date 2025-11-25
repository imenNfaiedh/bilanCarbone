package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CompanyDto;
import com.example.forms_collect.dto.FroidBilanMatiereDto;
import com.example.forms_collect.entity.Company;
import com.example.forms_collect.entity.FroidBilanMatiere;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface IFroidBilanMatiereMapper {

    FroidBilanMatiereDto toDto (FroidBilanMatiere FroidBilanMatiere);
    List<FroidBilanMatiereDto> toDto (List<FroidBilanMatiere> FroidBilanMatieres);
    FroidBilanMatiere toEntity(FroidBilanMatiereDto FroidBilanMatiereDto);
    List<FroidBilanMatiere> toEntity (List<FroidBilanMatiereDto> FroidBilanMatiereDtos);
}
