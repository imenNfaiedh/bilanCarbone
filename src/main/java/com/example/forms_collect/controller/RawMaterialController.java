package com.example.forms_collect.controller;

import com.example.forms_collect.dto.RawMaterialDto;
import com.example.forms_collect.service.IRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raw-materials")
public class RawMaterialController {

    @Autowired
    private IRawMaterialService service;

    @PostMapping
    public ResponseEntity<RawMaterialDto> create(@RequestBody RawMaterialDto dto) {
        RawMaterialDto saved = service.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
