package com.proyecto.demo1.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class Globalcontroller {

    @ModelAttribute
    public void agregarUsuarioLogueadoAlModelo(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");
        String admin = (String) session.getAttribute("adminLogueado");

        if (admin != null) {
            model.addAttribute("adminLogueado", admin);
        }

        if (usuario != null) {
            model.addAttribute("usuarioLogueado", usuario);
        }
    }
}

