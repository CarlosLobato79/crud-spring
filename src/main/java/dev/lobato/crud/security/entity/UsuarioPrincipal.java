package dev.lobato.crud.security.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

    @Getter
    private String nombre;
    private String nombreUsuario;
    private String password;
    @Getter
    private String email;

    private Collection<? extends GrantedAuthority> authorities;


    public UsuarioPrincipal(String nombre, String nombreUsuario, String password, String email, Collection<? extends GrantedAuthority> authorities){
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol ->new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());

        return new UsuarioPrincipal(usuario.getNombre(),usuario.getNombreUsuario(), usuario.getPassword(),usuario.getEmail() , authorities);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
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


}
