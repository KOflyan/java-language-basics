package com.pokemon.pokemonapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {
    public static final String SECRET = "8Wzf1SHPIvo6rXNLuPx1Ns7qyEcKF4lkfMEF3TTgD8rgylgqSh";

    public Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Boolean validateToken(
            Claims claims,
            UserDetails userDetails
    ) {
        return claims.getSubject().equals(userDetails.getUsername());
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
