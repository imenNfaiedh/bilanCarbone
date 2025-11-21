package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.entity.Combustible;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})

public interface ICombustibleMapper {
    CombustibleDto toDto(Combustible combustible);

    List<CombustibleDto> toDto(List<Combustible> combustibles);

    Combustible toEntity(CombustibleDto combustibleDto);

    List<Combustible> toEntity(List<CombustibleDto> combustibleDtos);
}
