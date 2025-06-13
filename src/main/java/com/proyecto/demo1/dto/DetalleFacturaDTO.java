package com.proyecto.demo1.dto;

import java.time.LocalDate;


public class DetalleFacturaDTO {
    private String codFactura;
    private String nombreCliente;
    private String apellidoCliente;
    private String tituloPelicula;
    private LocalDate fechaFactura;
    private int cantidadAsientos;
    private double subtotal;
    
    public String getCodFactura() {
        return codFactura;
    }
    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    public String getTituloPelicula() {
        return tituloPelicula;
    }
    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }
    public LocalDate getFechaFactura() {
        return fechaFactura;
    }
    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    public int getCantidadAsientos() {
        return cantidadAsientos;
    }
    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
}
