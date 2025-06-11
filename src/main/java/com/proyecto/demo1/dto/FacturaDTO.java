package com.proyecto.demo1.dto;

import java.time.LocalDate;

public class FacturaDTO {
    private String facCod;
    private String nombreUsuario;
    private LocalDate fecha;

    public FacturaDTO(String facCod,String nombreUsuario,LocalDate fecha){
        this.facCod=facCod;
        this.nombreUsuario=nombreUsuario;
        this.fecha=fecha;
    }

    public String getFacCod() {
        return facCod;
    }

    public void setFacCod(String facCod) {
        this.facCod = facCod;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
