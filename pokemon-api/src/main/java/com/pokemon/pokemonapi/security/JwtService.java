//package com.pokemon.pokemonapi.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class JwtService {
//    public static final String SECRET = "8Wzf1SHPIvo6rXNLuPx1Ns7qyEcKF4lkfMEF3TTgD8rgylgqSh";
//
//    public Claims extractAllClaims(String token) {
//        return Jwts
//                .parser()
//                .verifyWith(getSignKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    public Boolean validateToken(
//            Claims claims,
//            UserDetails userDetails
//    ) {
//        return claims.getSubject().equals(userDetails.getUsername());
//    }
//
//    private Boolean isTokenExpired(Claims claims) {
//        return claims.getExpiration().before(new Date());
//    }
//
//    private String createToken(String username) {
//        return createToken(new HashMap<>(), username);
//    }
//    private String createToken(Map<String, Object> claims, String username) {
//        return Jwts.builder()
//                .claims(claims)
//                .subject(username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .signWith(getSignKey()).compact();
//    }
//
//    private SecretKey getSignKey() {
//        return Keys.hmacShaKeyFor(SECRET.getBytes());
//    }
//}
