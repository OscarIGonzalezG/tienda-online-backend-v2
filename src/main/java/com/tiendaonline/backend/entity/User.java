package com.tiendaonline.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Esta clase representa un usuario del sistema
 * Tiene los campos necesarios para la autenticación y autorización.
 * Los roles pueden ser: ADMIN, VENDEDOR, CLIENTE.
 */
@Entity
@Table(name = "users") //Evita conflictos con la palabra reservada "user"
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
