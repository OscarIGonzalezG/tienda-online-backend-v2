package com.tiendaonline.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase de configuración general para beans comunes.
 */
@Configuration
public class AppConfig {

    /**
     * Bean que permite encriptar contraseña con BCrypt.
     * Spring lo inyectará automáticamente donde se necesita.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
