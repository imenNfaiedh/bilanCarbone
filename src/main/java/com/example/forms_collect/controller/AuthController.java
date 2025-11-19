package com.example.forms_collect.controller;

import com.example.forms_collect.dto.LoginUserDto;
import com.example.forms_collect.dto.RegisterUserDto;
import com.example.forms_collect.entity.User;
import com.example.forms_collect.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto request) {
        User user = authenticationService.signup(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto request) {
        String token = authenticationService.authenticate(request);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
