package com.proyecto.demo1.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.proyecto.demo1.Model.Usuario;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public List<Usuario> obteneUsuarios(){
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id){
        return usuarios.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
