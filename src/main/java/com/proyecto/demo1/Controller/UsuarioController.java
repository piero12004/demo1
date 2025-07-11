package com.proyecto.demo1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.UsuarioRepository;
import com.proyecto.demo1.Service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    // Página de formulario para registrar usuario
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registroUsuario"; 
    }


    // Guardar usuario y redirigir al listado
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuario.setRol("ROLE_USER");
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login"; 
    }

    // Mostrar lista de usuarios registrados
    @GetMapping("/admin/listaUsuarios")
    public String mostrarListaUsuarios(Model model) {
    model.addAttribute("usuarios", usuarioRepository.findAll());
    return "listaUsuarios"; 
    }

    //hace una busqueda por id y lo muestra en una tabla sin dejar de mostrar la tabla inicial
    @PostMapping("/admin/buscarUsuario")
    public String buscarPorId(@RequestParam String id, Model model){
        Optional <Usuario> usua = usuarioRepository.findById(id);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("resultadoUsuario", usua.orElse(null));
        return "listaUsuarios";
    }


    //elimina usuario por id/ no funciona porque esta relacionado con facturas
    @GetMapping("/admin/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id){
        usuarioRepository.deleteById(id);;
        return "redirect:/listaUsuarios";
    }

}

