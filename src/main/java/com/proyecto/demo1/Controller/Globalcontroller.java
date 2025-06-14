package com.proyecto.demo1.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class Globalcontroller {

    //html acceden al nombre de administrador o usuario
    @ModelAttribute
    public void agregarUsuarioLogueadoAlModelo(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");
        String codigo = (String) session.getAttribute("ucod");
        String admin = (String) session.getAttribute("adminLogueado");

        if (admin != null) {
            model.addAttribute("adminLogueado", admin);
        }

        if (usuario != null) {
            model.addAttribute("usuarioLogueado", usuario);
            model.addAttribute("ucod", codigo);
        }
    }
}

