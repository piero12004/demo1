package com.proyecto.demo1.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Facturas")
public class Factura {
    @Id
    private String facCod;

    @ManyToOne
    @JoinColumn(name="ucod")
    private Usuario usuario;

    private LocalDate fecha;

    public String getFacCod() {
        return facCod;
    }

    public void setFacCod(String facCod) {
        this.facCod = facCod;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
