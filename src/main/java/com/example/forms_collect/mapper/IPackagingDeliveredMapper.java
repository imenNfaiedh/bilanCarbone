package com.example.forms_collect.mapper;

import com.example.forms_collect.dto.PackagingDeliveredDto;
import com.example.forms_collect.entity.PackagingDelivered;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPackagingDeliveredMapper {
    PackagingDeliveredDto toDto(PackagingDelivered entity);
    PackagingDelivered toEntity(PackagingDeliveredDto dto);

    List<PackagingDeliveredDto> toDto(List<PackagingDelivered> list);
    List<PackagingDelivered> toEntity(List<PackagingDeliveredDto> list);
}
