package com.proyecto.demo1.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Service.DetalleFacturaService;
import com.proyecto.demo1.Service.FacturaService;

@Controller
public class CarritoController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @PostMapping("/carrito/confirmar")
    public String procesarCompra(
            @RequestParam("ucod") String ucod,
            @RequestParam("peliCod") String peliCod,
            @RequestParam("asientos") int asientos,
            @RequestParam("fechaFuncion") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFuncion,
            @RequestParam("horarioFuncion") String horarioFuncion,
            RedirectAttributes redirectAttributes) {
        try {
            Factura nuevaFactura = facturaService.crearFacturaYRetornar(ucod);
            detalleFacturaService.guardarDetalleFactura(nuevaFactura, peliCod, asientos, fechaFuncion, horarioFuncion);
            redirectAttributes.addFlashAttribute("compraExitosa", true);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error al procesar la compra: " + e.getMessage());
        }
        return "redirect:/cartelera";
    }
}
