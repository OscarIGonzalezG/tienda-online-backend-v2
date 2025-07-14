package com.tiendaonline.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 * Servicio que gestiona la creación, validación y lectura de JWT.
 */
@Service
public class JwtService {

    // Clave secreta para firmar el token (debe ser privada y segura)
    private static final String SECRET_KEY = "MiClaveSuperSecretaParaFirmarJwtDeFormaSegura123456789";

    // Tiempo de expiración en milisegundos (ej: 1 hora)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    /**
     * Genera un token JWT usando el email como subject.
     * @param email Email del usuario autenticado
     * @return Token JWT firmado
     */
    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email) // Asina el Subject al token
                .setIssuedAt(new Date()) //Fecha actual
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expira en 1 hora
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Firmamos con algoritmo y clave
                .compact(); // Compacta para obtener el JWT
    }

    /**
     * Válida que el token sea correcto (firma válida y no expirado).
     * @param token Token JWT a validar
     * @param email Email de usuario autenticado
     * @return true si es válido, false si no
     */
    public boolean isTokenValid(String token, String email){
        final String emailFromToken = extractUsername(token);
        return (emailFromToken.equals(email)) && !isTokenExpired(token);
    }

    /**
     * Extraer el mail (subject) desde el token.
     * @param token Token JWT
     * @return Email extraído
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Verifica si el token ya está expirado.
     * @param token Token JWT
     * @return true si está expirado, false si no.
     */
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extrae la fecha de expiración del token.
     * @param token Token JWT
     * @return Fecha de expiración
     */
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extraer cualquier claim personalizado del token.
     * @param token Token JWT
     * @param claimsResolver Función que indica qué claim extraer
     * @return Valor de claim
     * @param <T> Tipo genérico del claims
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrae todos los claims del token (payload decodificado).
     * @param token Token JWT
     * @return Todos los claims
     */
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Genera y devuelve la clave de firma para validar el JWT.
     * @return Clave secreta en formato Key
     */
    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
