package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.dto.ProductionWasteDto;
import com.example.forms_collect.entity.ProductionWaste;
import com.example.forms_collect.mapper.IProductionWasteMapper;
import com.example.forms_collect.repository.ProductionWasteRepository;
import com.example.forms_collect.service.IProductionWasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionWasteServiceImpl implements IProductionWasteService {

    @Autowired
    private ProductionWasteRepository productionWasteRepository;

    @Autowired
    private IProductionWasteMapper mapper;

    @Override
    public ProductionWasteDto save(ProductionWasteDto productionWasteDto) {
        ProductionWaste productionWaste = mapper.toEntity(productionWasteDto);
        ProductionWaste saved = productionWasteRepository.save(productionWaste);
        return mapper.toDto(saved);
    }
}