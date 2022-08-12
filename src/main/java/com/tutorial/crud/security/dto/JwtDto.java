package com.tutorial.crud.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authorithies;

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authorithies) {
        this.token = token;
        this.userName = userName;
        this.authorithies = authorithies;
    }
}
