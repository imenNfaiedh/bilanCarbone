package com.example.forms_collect.controller;

import com.example.forms_collect.dto.FroidEquipementDto;
import com.example.forms_collect.service.IFroidEquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/froid-equipement")
public class FroidEquipementController {

    private final IFroidEquipementService service;

    public FroidEquipementController(IFroidEquipementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FroidEquipementDto> add(@RequestBody FroidEquipementDto dto) {
        FroidEquipementDto saved = service.saveFroidEquipement(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
