package com.example.forms_collect.controller;
import com.example.forms_collect.dto.EvocationDto;
import com.example.forms_collect.service.IEvocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evocations")

public class EvocationController {

    private final IEvocationService evocationService;

    public EvocationController(IEvocationService evocationService) {
        this.evocationService = evocationService;
    }

    @PostMapping
    public ResponseEntity<EvocationDto> save(@RequestBody EvocationDto evocationDto) {
        EvocationDto saved = evocationService.saveEvocation(evocationDto);
        return ResponseEntity.ok(saved);
    }
}
