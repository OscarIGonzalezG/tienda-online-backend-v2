package com.tiendaonline.backend.dto;

import com.tiendaonline.backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para enviar la respuesta de autenticación
 */
@Data
@AllArgsConstructor
public class AuthResponse {
    private String name;
    private String email;
    private Role role;
    private String token;
}
