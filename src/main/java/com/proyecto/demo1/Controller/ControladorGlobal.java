package com.proyecto.demo1.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class ControladorGlobal {
    @ModelAttribute
        public void agregarDatosGlobales(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            String nombreUsuario = authentication.getName();
             model.addAttribute("usuarioLogueado", nombreUsuario);
            boolean esAdmin = authentication.getAuthorities().stream()
            .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
            if (esAdmin) {
            model.addAttribute("adminLogueado", nombreUsuario);
        }
        }
    }
}
