package com.tiendaonline.backend.service;

import com.tiendaonline.backend.dto.LoginResponseDTO;
import com.tiendaonline.backend.entity.User;
import com.tiendaonline.backend.security.JwtService;
import com.tiendaonline.backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Servicio que gestiona la lógica de autenticación y generación de JWT.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    /**
     * Autentica al usuario y genera un JWT si las credenciales son correctas
     * @param email Email del usuario
     * @param password Contraseña del usuario
     * @return DTO con los datos del usuario y su token
     */
    public LoginResponseDTO login(String email, String password){
        // Creamos el token para que el authentication manager lo procese
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(email, password));

        // Obtenemos el usuario autenticado desde el contexto
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        // Generamos el token JWT con el email
        String token = jwtService.generateToken(user.getEmail());

        // Retornamos los datos junto al token
        return new LoginResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                token
        );
    }
}
