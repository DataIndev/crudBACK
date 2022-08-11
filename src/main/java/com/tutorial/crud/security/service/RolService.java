package com.tutorial.crud.security.service;

import com.tutorial.crud.security.entity.Rol;
import com.tutorial.crud.security.enums.RolNombre;
import com.tutorial.crud.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> findByRolName(RolNombre rolName){
        return rolRepository.findByRolName(rolName);
    }


}
