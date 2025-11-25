package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.FroidEquipementDto;
import com.example.forms_collect.entity.FroidEquipement;
import com.example.forms_collect.mapper.IFroidEquipementMapper;
import com.example.forms_collect.repository.IFroidEquipementRepository;
import com.example.forms_collect.service.IFroidEquipementService;
import org.springframework.stereotype.Service;

@Service
public class FroidEquipementServiceImpl implements IFroidEquipementService {

    private final IFroidEquipementRepository repository;
    private final IFroidEquipementMapper mapper;

    public FroidEquipementServiceImpl(IFroidEquipementRepository repository,
                                      IFroidEquipementMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FroidEquipementDto saveFroidEquipement(FroidEquipementDto dto) {
        FroidEquipement froidEquipement = mapper.toEntity(dto);
        FroidEquipement saved = repository.save(froidEquipement);
        return mapper.toDto(saved);
    }
}
