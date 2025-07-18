package com.proyecto.demo1.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Service.FacturaService;
import com.proyecto.demo1.dto.FacturaDTO;



@Controller
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas")
    public String listarFacturas(Model model) {
        List<FacturaDTO> facturas = facturaService.obtenerFacturasConUsuario();
        model.addAttribute("facturas", facturas);
        return "listaFacturas";
    }

    @GetMapping("/facturas/usuario/{ucod}")
    public String verFacturasPorUsuario(@PathVariable String ucod, Model model) {
        List<Factura> facturas = facturaService.obtenerFacturasPorUsuario(ucod);
        model.addAttribute("facturasUsuario", facturas);
        return "factporU";
    }

    // Generar factura sin detalle 
    @GetMapping("/GenerarFactura")
    public String crearFactura(@RequestParam("ucod") String ucod, RedirectAttributes redirectAttributes) {
        try {
            facturaService.crearFacturaYRetornar(ucod);
            redirectAttributes.addFlashAttribute("compraExitosa", true);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "No se pudo generar la factura: " + e.getMessage());
        }
        return "redirect:/cartelera"; 
    }
}
