package com.proyecto.demo1.Model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @Column(name = "cod_detalle")
    private String codDetalle;

    @ManyToOne
    @JoinColumn(name = "fac_cod")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "peli_cod")
    private Pelicula pelicula;

    @Column(name = "asientos")
    private int asientos;

    @Column(name = "fecha_funcion")
    private LocalDate fechaFuncion;

    @Column(name = "horario_funcion")
    private String horarioFuncion;

    public String getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(String codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public LocalDate getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(LocalDate fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String getHorarioFuncion() {
        return horarioFuncion;
    }

    public void setHorarioFuncion(String horarioFuncion) {
        this.horarioFuncion = horarioFuncion;
    }

    
}