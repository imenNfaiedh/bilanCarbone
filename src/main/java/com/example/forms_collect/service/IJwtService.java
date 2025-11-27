package com.example.forms_collect.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface IJwtService {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    long getExpirationTime();

    boolean isTokenValid(String token, UserDetails userDetails);

    // Nouvelles méthodes pour extraire les informations utilisateur
    Long extractUserId(String token);

    String extractFullName(String token);

    String extractUserRole(String token);

    String extractLicenceType(String token);

    String extractSociete(String token);

    String extractTelephone(String token);

    Boolean extractEnabled(String token);

    Boolean extractExpired(String token);

    String extractExpirationDate(String token);

    Map<String, Object> extractAllUserClaims(String token);
}