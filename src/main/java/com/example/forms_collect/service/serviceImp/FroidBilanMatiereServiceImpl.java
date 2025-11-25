package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.FroidBilanMatiereDto;
import com.example.forms_collect.entity.FroidBilanMatiere;
import com.example.forms_collect.mapper.IFroidBilanMatiereMapper;
import com.example.forms_collect.repository.IFroidBilanMatiereRepository;
import com.example.forms_collect.service.IFroidBilanMatiereService;
import org.springframework.stereotype.Service;

@Service
public class FroidBilanMatiereServiceImpl implements IFroidBilanMatiereService {

    private final IFroidBilanMatiereRepository froidBilanMatiereRepository;
    private final IFroidBilanMatiereMapper froidBilanMatiereMapper;

    public FroidBilanMatiereServiceImpl(IFroidBilanMatiereRepository froidBilanMatiereRepository, IFroidBilanMatiereMapper froidBilanMatiereMapper) {
        this.froidBilanMatiereRepository = froidBilanMatiereRepository;
        this.froidBilanMatiereMapper = froidBilanMatiereMapper;

    }

    @Override
    public FroidBilanMatiereDto saveFroidBilanMatiere(FroidBilanMatiereDto froidBilanMatiereDto) {
        FroidBilanMatiere froidBilanMatiere =froidBilanMatiereMapper.toEntity(froidBilanMatiereDto);
        FroidBilanMatiere saved = froidBilanMatiereRepository.save(froidBilanMatiere);
        return  froidBilanMatiereMapper.toDto(saved);
    }
}

