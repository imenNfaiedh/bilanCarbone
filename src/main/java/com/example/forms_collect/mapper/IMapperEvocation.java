package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.EvocationDto;
import com.example.forms_collect.entity.Evocation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface IMapperEvocation {

    EvocationDto toDto(Evocation evocation);

    List<EvocationDto> toDto(List<Evocation> evocations);

    Evocation toEntity(EvocationDto evocationDto);

    List<Evocation> toEntity(List<EvocationDto> evocationDtos);
}
