package com.tiendaonline.backend.service;

import com.tiendaonline.backend.dto.AuthResponse;
import com.tiendaonline.backend.dto.LoginRequest;
import com.tiendaonline.backend.dto.RegisterRequest;
import com.tiendaonline.backend.entity.Role;
import com.tiendaonline.backend.entity.User;
import com.tiendaonline.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio que maneja el registro y login de usuarios.
 * Usa el repositorio y codificador de contraseña
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //JWTService irá aquí más adelante

    /**
     * Registra un nuevo usuario si no existe.
     */
    public AuthResponse register(RegisterRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw  new RuntimeException("El correo ya está en uso");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENTE) // Por defecto, todos se registran como CLIENTE
                .build();

        userRepository.save(user);

        // En el futuro, generar token con JWT aquí
        return new AuthResponse(user.getName(), user.getEmail(), user.getRole(), "token-demo");
    }


    /**
     * Autentica un usuario existente.
     */
    public AuthResponse login(LoginRequest request){
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()){
            throw new RuntimeException("Correo no registrado");
        }

        User user =userOpt.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }

        //Aquí también se generará token real
        return new AuthResponse(user.getName(), user.getEmail(), user.getRole(), "token-demo");
    }
}
