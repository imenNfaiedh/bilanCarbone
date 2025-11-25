package com.example.forms_collect.controller;

import com.example.forms_collect.dto.PackagingMaterialDto;
import com.example.forms_collect.service.IPackagingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packaging-material")
public class PackagingMaterialController {

    @Autowired
    private IPackagingMaterialService packagingMaterialService;

    @PostMapping
    public ResponseEntity<PackagingMaterialDto> add(@RequestBody PackagingMaterialDto dto) {
        PackagingMaterialDto saved = packagingMaterialService.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
