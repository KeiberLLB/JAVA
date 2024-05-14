package com.riwi.beautySalon.infrastructure.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
  // Crear una variable para guardar mi llave privada (FIRMA)
  private static final String SECRET_KEY = "bWkgY2xhdmUgc3VwZXIgaHlwZXIgbWVnYSB1bHRyYSBzZWNyZXRlaWNob24gY2xhdmUgbWFtYWxvbmE=";

  public SecretKey getKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    // Retornar nuestra llave encriptada
    return Keys.hmacShaKeyFor(keyBytes);
  }

  // Método para construir nuestro token
  public String getToken(Map<String, Object> claims, User user) {

    return Jwts.builder()
        .claims(claims) // Agregamos el payload del jwt
        .subject(user.getUsername()) // Agragamos de quien es el jwt
        .issuedAt(new Date(System.currentTimeMillis())) // Agregamos cuando se creo el token
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Agregamos el tiempo de expiración
        .signWith(this.getKey()) // Agregamos la firma
        .compact();
  }

  // Método para retornar el token con los claims configurados
  public String getToken(User user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", user.getId());
    claims.put("role", user.getRole().name());
    return this.getToken(claims, user);
  }
}
