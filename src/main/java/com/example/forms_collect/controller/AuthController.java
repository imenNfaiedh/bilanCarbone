package com.example.forms_collect.controller;

import com.example.forms_collect.dto.LoginUserDto;
import com.example.forms_collect.dto.RegisterUserDto;
import com.example.forms_collect.entity.User;
import com.example.forms_collect.service.AuthenticationService;
import com.example.forms_collect.service.serviceImp.JwtServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtServiceImpl jwtServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto request) {
        User user = authenticationService.signup(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto request) {
        Map<String, Object> authResult = authenticationService.authenticate(request);
        String token = (String) authResult.get("token");
        User user = (User) authResult.get("user");

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", createUserResponse(user));
        response.put("tokenType", "Bearer");
        response.put("expiresIn", jwtServiceImpl.getExpirationTime());

        return ResponseEntity.ok(response);
    }
    // AJOUTER CETTE MÉTHODE MANQUANTE
    private Map<String, Object> createUserResponse(User user) {
        Map<String, Object> userResponse = new HashMap<>();
        userResponse.put("id", user.getId());
        userResponse.put("fullName", user.getFullName());
        userResponse.put("email", user.getEmail());
        userResponse.put("role", user.getRole().name());
        userResponse.put("licenceType", user.getLicenceType());
        userResponse.put("societe", user.getSociete());
        userResponse.put("telephone", user.getTelephone());
        userResponse.put("description", user.getDescription());
        userResponse.put("enabled", user.isEnabled());
        userResponse.put("expired", user.isExpired());
        userResponse.put("expirationDate", user.getExpirationDate());
        userResponse.put("createdAt", user.getCreatedAt());

        return userResponse;
    }
}
