package com.proyecto.demo1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //genera nuevo codigo(U000x)
    public void guardarUsuario(Usuario usuario) {
        if (usuario.getUcod() == null || usuario.getUcod().isEmpty()) {
            String ultimoCodigo = usuarioRepository.findUltimoCodigo(); 

            int num = 1;
            if (ultimoCodigo != null && ultimoCodigo.startsWith("U")) {
                num = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
            }

            String nuevoCodigo = "U" + String.format("%04d", num); 
            usuario.setUcod(nuevoCodigo);
        }

        usuarioRepository.save(usuario);
    }
}
