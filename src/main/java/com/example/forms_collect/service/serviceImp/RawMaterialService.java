package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.RawMaterialDto;
import com.example.forms_collect.entity.RawMaterial;
import com.example.forms_collect.mapper.IMapperRawMaterial;
import com.example.forms_collect.repository.IRawMaterialRepository;
import com.example.forms_collect.service.IRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawMaterialService implements IRawMaterialService {

    @Autowired
    private IRawMaterialRepository repository;

    @Autowired
    private IMapperRawMaterial mapper;

    @Override
    public RawMaterialDto save(RawMaterialDto dto) {
        RawMaterial rawMaterial = mapper.toEntity(dto);
        RawMaterial saved = repository.save(rawMaterial);
        return mapper.toDto(saved);
    }
}
