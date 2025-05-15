package com.proyecto.demo1.Controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Controlador {

    @GetMapping({"/","/PRINCIPAL"})
    public String pPrincipal() {
        return "PRINCIPAL";
    }
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
    
    //VALIDAR USUARIO 
    @PostMapping("/validar")
    public String validarLogin(@RequestParam String usuario, @RequestParam String clave, Model model) {
        if (usuario.equals("piero") && clave.equals("12004")) {
            
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Usuario o clave incorrectos");
            return "login";
        }
    }


    @GetMapping("/admin")
    public String mostrarGrafico(Model model) {
        List<String> etiquetas = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio");
        List<Integer> valores = Arrays.asList(100, 500, 1500, 2500, 1800, 3000);

        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("valores", valores);

        return "admin"; 
    }

    @GetMapping("/admin")
    public String mostrarGrafico2(Model model) {
        List<String> etiquetas = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio");
        List<Integer> valores = Arrays.asList(100, 350, 679, 438, 190, 632);

        model.addAttribute("etiquetas2", etiquetas);
        model.addAttribute("valores2", valores);

        return "admin"; 
    }

}

    

