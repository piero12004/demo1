package com.proyecto.demo1.Service;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Model.Admin;
import com.proyecto.demo1.Repository.UsuarioRepository;
import com.proyecto.demo1.Repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByUsuario(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

    return User.builder()
        .username(usuario.getUsuario())
        .password(usuario.getContrasenia())
        .authorities(new SimpleGrantedAuthority(usuario.getRol()))
        .build(); 
        
    }

}
