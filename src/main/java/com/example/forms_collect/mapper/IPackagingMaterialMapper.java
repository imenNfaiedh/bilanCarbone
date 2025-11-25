package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.PackagingMaterialDto;
import com.example.forms_collect.entity.PackagingMaterial;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPackagingMaterialMapper {
    PackagingMaterialDto toDto(PackagingMaterial entity);
    PackagingMaterial toEntity(PackagingMaterialDto dto);

    List<PackagingMaterialDto> toDto(List<PackagingMaterial> list);
    List<PackagingMaterial> toEntity(List<PackagingMaterialDto> list);
}

