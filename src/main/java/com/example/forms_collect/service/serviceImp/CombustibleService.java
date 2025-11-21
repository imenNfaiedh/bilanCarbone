package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.entity.Combustible;
import com.example.forms_collect.mapper.ICombustibleMapper;
import com.example.forms_collect.repository.ICombustibleRepository;
import com.example.forms_collect.service.ICombustibleService;
import org.springframework.stereotype.Service;

@Service
public class CombustibleService implements ICombustibleService {

    private final ICombustibleRepository combustibleRepository;
    private final ICombustibleMapper combustibleMapper;
    public CombustibleService(ICombustibleRepository combustibleRepository, ICombustibleMapper combustibleMapper) {
        this.combustibleRepository = combustibleRepository;
        this.combustibleMapper = combustibleMapper;
    }

    @Override
    public CombustibleDto saveCombustible(CombustibleDto combustibleDto) {
        Combustible combustible= combustibleMapper.toEntity(combustibleDto);
        Combustible saved = combustibleRepository.save(combustible);
        return combustibleMapper.toDto(saved);
    }
}
