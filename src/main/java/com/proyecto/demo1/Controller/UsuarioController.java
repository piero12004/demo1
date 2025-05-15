package com.proyecto.demo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Service.UsuarioService;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Página de formulario para registrar usuario
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario("", ""));
        return "registroUsuario"; 
    }


    // Guardar usuario (localmente) y redirigir al listado
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.agregarUsuario(usuario);
        return "redirect:/PRINCIPAL"; 
    }

    // Mostrar lista de usuarios registrados
    @GetMapping("/listaUsuarios")
    public String mostrarListaUsuarios(Model model) {
    model.addAttribute("usuarios", usuarioService.obteneUsuarios());
    return "listaUsuarios"; 
    }

    //hace una busqueda por id y lo muestra en una tabla sin dejar de moestrar la tabla inicial
    @PostMapping("/buscarEmpleado")
    public String buscarPorId(@RequestParam int id, Model model){
        Usuario usua = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuarios", usuarioService.obteneUsuarios());
        model.addAttribute("resultadoUsuario", usua);
        return "listaUsuarios";
    }


    //elimina usuario por id
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id){
        usuarioService.eliminarUsuario(id);
        return "redirect:/listaUsuarios";
    }

}

