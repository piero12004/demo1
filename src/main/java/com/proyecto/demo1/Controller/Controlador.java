package com.proyecto.demo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Controlador {

    @GetMapping("/PRINCIPAL")
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

    
}
