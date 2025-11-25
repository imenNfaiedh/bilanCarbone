package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.PackagingMaterialDto;
import com.example.forms_collect.entity.PackagingMaterial;
import com.example.forms_collect.mapper.IPackagingMaterialMapper;
import com.example.forms_collect.repository.PackagingMaterialRepository;
import com.example.forms_collect.service.IPackagingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagingMaterialServiceImpl implements IPackagingMaterialService {

    @Autowired
    private PackagingMaterialRepository packagingMaterialRepository;

    @Autowired
    private IPackagingMaterialMapper mapper;

    @Override
    public PackagingMaterialDto save(PackagingMaterialDto packagingMaterialDto) {
        PackagingMaterial packagingMaterial = mapper.toEntity(packagingMaterialDto);
        PackagingMaterial saved = packagingMaterialRepository.save(packagingMaterial);
        return mapper.toDto(saved);
    }
}
