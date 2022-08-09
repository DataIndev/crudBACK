package com.tutorial.crud.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String user;
    @NotNull
    @Column (unique = true)
    private String userName;
    @NotNull
    private String userEmail;
    @NotNull
    private String userPassword;
    @NotNull
    @ManyToMany
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String user, String userName, String userEmail, String userPassword) {
        this.user = user;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
