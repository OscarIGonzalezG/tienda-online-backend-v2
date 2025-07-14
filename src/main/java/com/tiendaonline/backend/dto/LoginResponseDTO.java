package com.tiendaonline.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String name;
    private String email;
    private String role;
    private String token;
}
