package com.tiendaonline.backend.controller;

import com.tiendaonline.backend.dto.AuthResponse;
import com.tiendaonline.backend.dto.LoginRequest;
import com.tiendaonline.backend.dto.RegisterRequest;
import com.tiendaonline.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que expone las rutas públicas de autenticación.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    /**
     * Ruta para registrar un nuevo usuario (rol CLIENTE por defecto).
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Ruta para iniciar sesión (login).
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
