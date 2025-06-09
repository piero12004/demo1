package com.proyecto.demo1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarUsuario(Usuario usuario) {
        
        if (usuario.getId() == null || usuario.getId().isEmpty()) {
            String ultimoCodigo = usuarioRepository.findUltimoCodigo(); 

            int num = 1;
            if (ultimoCodigo != null && ultimoCodigo.startsWith("U")) {
                num = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
            }

            String nuevoCodigo = "U" + String.format("%04d", num); 
            usuario.setId(nuevoCodigo);
        }

        usuarioRepository.save(usuario);
    }
}
