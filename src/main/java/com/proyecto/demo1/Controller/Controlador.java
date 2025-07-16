package com.proyecto.demo1.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.proyecto.demo1.Repository.AdminRepository;
import com.proyecto.demo1.Repository.UsuarioRepository;



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
    @GetMapping("/PRINCIPAL")
    public String vistaInicial(){
        return "PRINCIPAL";
    }
    

    @GetMapping("/Bienvenido")
    public String redirigirPorRol() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

         if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin";
        }
        if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/PRINCIPAL";
        }
        return "redirect:/login?error";
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

    

