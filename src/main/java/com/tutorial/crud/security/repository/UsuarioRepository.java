package com.tutorial.crud.security.repository;

import com.tutorial.crud.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByUserEmail(String userEmail);
}
