package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.WaterSupplyDto;
import com.example.forms_collect.entity.WaterSupply;
import com.example.forms_collect.mapper.IMapperWaterSupply;
import com.example.forms_collect.repository.IWaterSupplyRepository;
import com.example.forms_collect.service.IWaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterSupplyService implements IWaterSupplyService {

    @Autowired
    private IWaterSupplyRepository repository;

    @Autowired
    private IMapperWaterSupply mapper;

    @Override
    public WaterSupplyDto save(WaterSupplyDto waterSupplyDto) {
        WaterSupply waterSupply = mapper.toEntity(waterSupplyDto);
        WaterSupply saved = repository.save(waterSupply);
        return mapper.toDto(saved);
    }
}
