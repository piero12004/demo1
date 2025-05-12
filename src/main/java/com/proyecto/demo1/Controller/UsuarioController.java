package com.proyecto.demo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Service.UsuarioService;

@Controller
public class UsuarioController{
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    

    @GetMapping("/login")
    public String formularioUsuario(Model model){
        model.addAttribute("usuario", new Usuario("", ""));
        return "/usu";
    }

    @GetMapping("/login")
    public String mostrarListaUsuario(Model model){
        model.addAttribute("usuarios", usuarioService.obteneUsuarios());
        return"";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.agregarUsuario(usuario);
        return"";
    }
    


}
