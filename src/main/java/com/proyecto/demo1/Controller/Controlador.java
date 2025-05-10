package com.proyecto.demo1.Controller;

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
            
            return "adminpag";
        } else {
            model.addAttribute("error", "Usuario o clave incorrectos");
            return "login";
        }
    }
    
}
