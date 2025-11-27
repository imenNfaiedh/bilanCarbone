package com.example.forms_collect.service.serviceImp;

import com.example.forms_collect.entity.User;
import com.example.forms_collect.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements IJwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        // Ajouter toutes les informations utilisateur dans les claims
        if (userDetails instanceof User user) {
            extraClaims.put("userId", user.getId());
            extraClaims.put("fullName", user.getFullName());
            extraClaims.put("email", user.getEmail());
            extraClaims.put("role", user.getRole().name());
            extraClaims.put("licenceType", user.getLicenceType());
            extraClaims.put("societe", user.getSociete());
            extraClaims.put("telephone", user.getTelephone());
            extraClaims.put("enabled", user.isEnabled());
            extraClaims.put("expired", user.isExpired());
            extraClaims.put("expirationDate", user.getExpirationDate() != null ?
                    user.getExpirationDate().toString() : null);
            extraClaims.put("description", user.getDescription());
            extraClaims.put("createdAt", user.getCreatedAt() != null ?
                    user.getCreatedAt().getTime() : null);
        }

        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    @Override
    public long getExpirationTime() {
        return jwtExpiration;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Nouvelles méthodes d'extraction

    @Override
    public Long extractUserId(String token) {
        return extractClaim(token, claims -> claims.get("userId", Long.class));
    }

    @Override
    public String extractFullName(String token) {
        return extractClaim(token, claims -> claims.get("fullName", String.class));
    }

    @Override
    public String extractUserRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    @Override
    public String extractLicenceType(String token) {
        return extractClaim(token, claims -> claims.get("licenceType", String.class));
    }

    @Override
    public String extractSociete(String token) {
        return extractClaim(token, claims -> claims.get("societe", String.class));
    }

    @Override
    public String extractTelephone(String token) {
        return extractClaim(token, claims -> claims.get("telephone", String.class));
    }

    @Override
    public Boolean extractEnabled(String token) {
        return extractClaim(token, claims -> claims.get("enabled", Boolean.class));
    }

    @Override
    public Boolean extractExpired(String token) {
        return extractClaim(token, claims -> claims.get("expired", Boolean.class));
    }

    @Override
    public String extractExpirationDate(String token) {
        return extractClaim(token, claims -> claims.get("expirationDate", String.class));
    }

    @Override
    public Map<String, Object> extractAllUserClaims(String token) {
        Claims claims = extractAllClaims(token);
        Map<String, Object> userClaims = new HashMap<>();

        userClaims.put("userId", claims.get("userId", Long.class));
        userClaims.put("fullName", claims.get("fullName", String.class));
        userClaims.put("email", claims.getSubject()); // email is the subject
        userClaims.put("role", claims.get("role", String.class));
        userClaims.put("licenceType", claims.get("licenceType", String.class));
        userClaims.put("societe", claims.get("societe", String.class));
        userClaims.put("telephone", claims.get("telephone", String.class));
        userClaims.put("enabled", claims.get("enabled", Boolean.class));
        userClaims.put("expired", claims.get("expired", Boolean.class));
        userClaims.put("expirationDate", claims.get("expirationDate", String.class));
        userClaims.put("description", claims.get("description", String.class));
        userClaims.put("createdAt", claims.get("createdAt", Long.class));
        userClaims.put("issuedAt", claims.getIssuedAt());
        userClaims.put("expiration", claims.getExpiration());

        return userClaims;
    }

    // Méthodes privées existantes

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}