package com.pokemon.pokemonapi.security;

import com.pokemon.pokemonapi.trainer.Trainer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public String createToken(Trainer trainer) {
        Map<String, ?> claims = new HashMap<>(){{
            put("id", trainer.getId());
            put("role", trainer.getRole());
        }};

        return Jwts.builder()
                .claims(claims)
                .subject(trainer.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignKey()).compact();
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
