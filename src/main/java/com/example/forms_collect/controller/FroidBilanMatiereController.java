package com.example.forms_collect.controller;

import com.example.forms_collect.dto.FroidBilanMatiereDto;
import com.example.forms_collect.service.IFroidBilanMatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/froid-bilan-matiere")

public class FroidBilanMatiereController {
    private final IFroidBilanMatiereService froidBilanMatiereService;

    public FroidBilanMatiereController(IFroidBilanMatiereService froidBilanMatiereService) {
        this.froidBilanMatiereService = froidBilanMatiereService;
    }
    @PostMapping
    public ResponseEntity<FroidBilanMatiereDto> addFroidBilanMatiere(@RequestBody FroidBilanMatiereDto froidBilanMatiereDto){
        FroidBilanMatiereDto save= froidBilanMatiereService.saveFroidBilanMatiere(froidBilanMatiereDto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
