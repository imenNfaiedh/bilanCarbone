package com.example.forms_collect.controller;


import com.example.forms_collect.dto.WaterSupplyDto;
import com.example.forms_collect.service.IWaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water-supply")
public class WaterSupplyController {

    @Autowired
    private IWaterSupplyService service;

    @PostMapping
    public ResponseEntity<WaterSupplyDto> create(@RequestBody WaterSupplyDto dto) {
        WaterSupplyDto saved = service.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
