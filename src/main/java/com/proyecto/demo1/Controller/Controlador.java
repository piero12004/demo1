package com.proyecto.demo1.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo1.Model.Admin;
import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.AdminRepository;
import com.proyecto.demo1.Repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;



@Controller
public class Controlador {
    @Autowired AdminRepository adminRepo;
    @Autowired UsuarioRepository usuarioRepo;

    
    @GetMapping("/Estrenos")
    public String pEstrenos() {
        return "Estrenos";
    }
    @GetMapping("/Contacto")
    public String pContacto() {
        return "Contacto";
    }
    @GetMapping("/cartelera")
    public String pCartelera() {
        return "cartelera";
    }
    @GetMapping("/login")
    public String pLogin() {
        return "login"; 
    }

    //La primera pagina que aparecera al correr el proyecto
    @GetMapping("/")
    public String vistaInicial(){
        return "PRINCIPAL";
    }
    
    //VALIDAR USUARIO 
    @PostMapping("/validar")
public String validarLogin(@RequestParam String usuario, @RequestParam String clave, Model model, HttpSession session) {
    // Limpia atributos anteriores para evitar que convivan usuario y admin
    session.removeAttribute("usuarioLogueado");
    session.removeAttribute("adminLogueado");

    Admin admin = adminRepo.findByAdminUsuarioAndAdminClave(usuario, clave);
    if (admin != null) {
        session.setAttribute("adminLogueado", admin.getAdminUsuario());
        return "redirect:/admin";
    }

    Usuario user = usuarioRepo.findByUsuarioAndContrasenia(usuario, clave);
    if (user != null) {
        session.setAttribute("usuarioLogueado", user.getUsuario());
        return "redirect:/PRINCIPAL";
    }

    model.addAttribute("error", "Usuario o clave incorrectos");
    return "login";
}

    @GetMapping("/PRINCIPAL")
    public String vistaUsuario(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");
        model.addAttribute("usuarioLogueado", usuario);
        return "PRINCIPAL";
    }


    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate(); // Cierra la sesión
        return "redirect:/login";
    }




    @GetMapping("/admin")
    public String mostrarGrafico(Model model) {
        List<String> etiquetas = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio");
        List<Integer> valores = Arrays.asList(100, 500, 1500, 2500, 1800, 3000);
        List<String> etiquetas2 = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio");
        List<Integer> valores2 = Arrays.asList(100, 1350, 2679, 1438, 3190, 3632);

        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("valores", valores);
        model.addAttribute("etiquetas2", etiquetas2);
        model.addAttribute("valores2", valores2);

        return "admin"; 
    }

}

    

