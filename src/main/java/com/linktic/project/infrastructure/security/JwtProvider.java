package com.linktic.project.infrastructure.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.linktic.project.application.dto.UserDTO;
import com.linktic.project.application.mappers.UserMapper;
import com.linktic.project.domain.models.User;
import com.linktic.project.domain.services.ITokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtProvider implements ITokenService {
    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey key;
    private static final long EXPIRATION_TIME = 86400000; // 1 día

    @PostConstruct
    public void init() {
        if (secretKey == null || secretKey.length() < 32) {
            throw new IllegalArgumentException("La clave secreta debe tener al menos 32 caracteres.");
        }
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateToken(final User user) {
        UserDTO userDto = UserMapper.toDto(user);
        return buildToken(userDto);
    }

    private String buildToken(final UserDTO user) {
        String token = Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim("role", user.getRole())
                .signWith(key)
                .compact();
        return token;
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     * 
     * @return Claims
     */
    @Override
    @SuppressWarnings("unchecked")
    public Claims validateTokenAndReturnClaims(String token) {
        return Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();
    }

}
