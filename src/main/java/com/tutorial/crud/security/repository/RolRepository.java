package com.tutorial.crud.security.repository;

import com.tutorial.crud.security.entity.Rol;
import com.tutorial.crud.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}
