package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.PackagingDeliveredDto;
import com.example.forms_collect.entity.PackagingDelivered;
import com.example.forms_collect.mapper.IPackagingDeliveredMapper;
import com.example.forms_collect.repository.PackagingDeliveredRepository;
import com.example.forms_collect.service.IPackagingDeliveredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagingDeliveredServiceImpl implements IPackagingDeliveredService {

    @Autowired
    private PackagingDeliveredRepository packagingDeliveredRepository;

    @Autowired
    private IPackagingDeliveredMapper mapper;

    @Override
    public PackagingDeliveredDto save(PackagingDeliveredDto packagingDeliveredDto) {
        PackagingDelivered entity = mapper.toEntity(packagingDeliveredDto);
        PackagingDelivered saved = packagingDeliveredRepository.save(entity);
        return mapper.toDto(saved);
    }
}
