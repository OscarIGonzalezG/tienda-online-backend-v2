package com.tiendaonline.backend.dto;

import lombok.Data;

/**
 * DTO para recibir los datos cuando el usuario se registra.
 */
@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
