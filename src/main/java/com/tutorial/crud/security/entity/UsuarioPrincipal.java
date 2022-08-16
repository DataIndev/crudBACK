package com.tutorial.crud.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
private String user;
private String userName;
private String userEmail;
private String userPassword;

private Collection<? extends GrantedAuthority> authorithies;

    public UsuarioPrincipal(String user, String userName, String userEmail, String userPassword, Collection<? extends GrantedAuthority> authorithies) {
        this.user = user;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.authorithies = authorithies;
    }

    public static UsuarioPrincipal build(Usuario name){
        List<GrantedAuthority> authorithies =
                name.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(name.getUser(), name.getUserName(), name.getUserEmail(),name.getUserPassword(),authorithies);


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUser() {
        return user;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
