package com.example.forms_collect.service.serviceImp;
import com.example.forms_collect.dto.EvocationDto;
import com.example.forms_collect.entity.Evocation;
import com.example.forms_collect.mapper.IMapperEvocation;
import com.example.forms_collect.repository.IEvocationRepository;
import com.example.forms_collect.service.IEvocationService;
import org.springframework.stereotype.Service;
@Service
public class EvocationService implements IEvocationService {

    private final IEvocationRepository evocationRepository;
    private final IMapperEvocation mapper;

    public EvocationService(IEvocationRepository evocationRepository,
                            IMapperEvocation mapper) {
        this.evocationRepository = evocationRepository;
        this.mapper = mapper;
    }

    @Override
    public EvocationDto saveEvocation(EvocationDto evocationDto) {

        // Convert DTO → Entity
        Evocation evocation = mapper.toEntity(evocationDto);

        // Save
        Evocation saved = evocationRepository.save(evocation);

        // Convert Entity → DTO
        return mapper.toDto(saved);
    }
}