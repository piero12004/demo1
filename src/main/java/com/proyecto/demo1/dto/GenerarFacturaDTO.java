package com.proyecto.demo1.dto;

import java.time.LocalDate;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Model.Usuario;

public class GenerarFacturaDTO {
 private Factura factura;

 public GenerarFacturaDTO(String fac_cod, Usuario usuario, LocalDate fecha) {
        factura = new Factura();
        factura.setFacCod(fac_cod);
        factura.setUsuario(usuario);
        factura.setFecha(fecha);
    }
 

 public Factura getFactura() {
    return factura;
 }

 public void setFactura(Factura factura) {
    this.factura = factura;
 }
}
