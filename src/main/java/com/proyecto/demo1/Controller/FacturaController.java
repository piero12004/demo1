package com.proyecto.demo1.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Service.FacturaService;
import com.proyecto.demo1.dto.FacturaDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    //mostrar la tabla general facturas
    @GetMapping("/facturas")
    public String listarFacturas(Model model) {
        List<FacturaDTO> facturas=facturaService.obtenerFacturasConUsuario();
        model.addAttribute("facturas",facturas);
        return "listaFacturas";
    }
    
    //mostrar la tabla de un usuario en especifico
    @GetMapping("/facturas/usuario/{ucod}")
    public String verFacturasPorUsuario(@PathVariable String ucod, Model model){
        List<Factura> facturas = facturaService.obteneFacturasPorUsuario(ucod);
        System.out.println("Facturas encontradas para " + ucod + ": " + facturas.size());
        model.addAttribute("facturasUsuario", facturas);
        return "factporU";
    }

    @GetMapping("/GenerarFactura")
    public String crearFactura(@RequestParam("ucod") String ucod, RedirectAttributes redirectAttributes){
        facturaService.crearFactura("",ucod,LocalDate.now());
        redirectAttributes.addFlashAttribute("compraExitosa", true);
        return "redirect:/mostrarPeliculas";
    }
}
