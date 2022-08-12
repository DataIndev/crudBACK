package com.tutorial.crud.security.service;

import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUserName(String userName){
        return usuarioRepository.findByUserName(userName);
    }

    public boolean existsByUserName(String userName){
        return usuarioRepository.existsByUserName(userName);
    }

    public boolean existsByUserEmail(String userEmail){
        return usuarioRepository.existsByUserEmail(userEmail);
    }

    public void save(Usuario user){
        usuarioRepository.save(user);
    }
}
