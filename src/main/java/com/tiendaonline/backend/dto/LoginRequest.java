package com.tiendaonline.backend.dto;

import lombok.Data;

/**
 * DTO para recibir datos de login
 */
@Data
public class LoginRequest {
    private String email;
    private  String password;
}
