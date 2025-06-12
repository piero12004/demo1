package com.proyecto.demo1.dto;

import java.time.LocalDate;

public class FacturaDTO {
    private String fac_cod;
    private String nombreUsuario;
    private LocalDate fecha;

    public FacturaDTO(String fac_cod,String nombreUsuario,LocalDate fecha){
       this.fac_cod = fac_cod;
       this.nombreUsuario = nombreUsuario;
       this.fecha = fecha;
    }

    

    public String getFac_cod() {
        return fac_cod;
    }

    public void setFac_cod(String fac_cod) {
        this.fac_cod = fac_cod;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombreUsuario = nombre;
    }

    

    
}
