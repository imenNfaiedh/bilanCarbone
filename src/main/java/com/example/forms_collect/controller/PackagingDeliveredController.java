package com.example.forms_collect.controller;

import com.example.forms_collect.dto.PackagingDeliveredDto;
import com.example.forms_collect.service.IPackagingDeliveredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packaging-delivered")
public class PackagingDeliveredController {

    @Autowired
    private IPackagingDeliveredService packagingDeliveredService;

    @PostMapping
    public ResponseEntity<PackagingDeliveredDto> add(@RequestBody PackagingDeliveredDto dto) {
        PackagingDeliveredDto saved = packagingDeliveredService.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
