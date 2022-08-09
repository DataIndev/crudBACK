package com.tutorial.crud.security.entity;

import com.tutorial.crud.security.enums.RolNombre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolName;

    public Rol() {
    }

    public Rol(RolNombre rolName) {
        this.rolName = rolName;
    }
}
