package com.tutorial.crud.util;

import com.tutorial.crud.security.entity.Rol;
import com.tutorial.crud.security.enums.RolName;
import com.tutorial.crud.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
        Rol rolUser = new Rol(RolName.ROLE_USER);

    }
}
