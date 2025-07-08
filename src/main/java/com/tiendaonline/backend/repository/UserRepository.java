package com.tiendaonline.backend.repository;

import com.tiendaonline.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad User.
 * Permite acceder a la DB sin necesidad de escribir SQL.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su email(usado para login).
     * @param email Correo del usuario
     * @return Optional con el usuario si existe
     */
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
