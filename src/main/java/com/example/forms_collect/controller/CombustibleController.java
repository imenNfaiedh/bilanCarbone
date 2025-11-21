package com.example.forms_collect.controller;

import com.example.forms_collect.dto.CombustibleDto;
import com.example.forms_collect.service.ICombustibleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combustibles")
public class CombustibleController {

    private final ICombustibleService combustibleService;

    public CombustibleController(ICombustibleService combustibleService) {
        this.combustibleService = combustibleService;
    }

    // Endpoint pour créer un combustible
    @PostMapping
    public CombustibleDto createCombustible(@RequestBody CombustibleDto combustibleDto) {
        return combustibleService.saveCombustible(combustibleDto);
    }
}
