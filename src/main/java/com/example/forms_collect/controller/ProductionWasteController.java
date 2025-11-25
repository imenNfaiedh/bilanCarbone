package com.example.forms_collect.controller;

import com.example.forms_collect.dto.ProductionWasteDto;
import com.example.forms_collect.service.IProductionWasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/production-waste")
public class ProductionWasteController {

    @Autowired
    private IProductionWasteService productionWasteService;

    @PostMapping
    public ResponseEntity<ProductionWasteDto> add(@RequestBody ProductionWasteDto productionWasteDto) {
        ProductionWasteDto saved = productionWasteService.save(productionWasteDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
