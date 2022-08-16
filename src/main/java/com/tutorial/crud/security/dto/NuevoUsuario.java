package com.tutorial.crud.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NuevoUsuario {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String userName;
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    private Set<String> roles = new HashSet<>();
}
