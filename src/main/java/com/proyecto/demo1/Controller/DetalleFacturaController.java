package com.proyecto.demo1.Controller;

import com.proyecto.demo1.Service.DetalleFacturaService;
import com.proyecto.demo1.dto.DetalleFacturaDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {

    private final DetalleFacturaService detalleFacturaService;

    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @GetMapping("/{facCod}")
    public String mostrarDetalle(@PathVariable String facCod, Model model) {
        try {
            DetalleFacturaDTO detalle = detalleFacturaService.obtenerDetalle(facCod);
            model.addAttribute("detalle", detalle);
            return "detalleFactura"; // archivo HTML en templates/detalleFactura.html
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "No se pudo obtener el detalle de la factura.");
            return "error"; 
        }
    }
}
