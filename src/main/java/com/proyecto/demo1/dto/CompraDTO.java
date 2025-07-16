package com.proyecto.demo1.dto;

import java.time.LocalDate;

public class CompraDTO {
    private String peliCod;
    private String peliTitulo;
    private int asientos;
    private LocalDate fechaFuncion;
    private String horarioFuncion;
    private String ucod;

    
    public String getPeliCod() {
        return peliCod;
    }
    public void setPeliCod(String peliCod) {
        this.peliCod = peliCod;
    }
    public String getPeliTitulo() {
        return peliTitulo;
    }
    public void setPeliTitulo(String peliTitulo) {
        this.peliTitulo = peliTitulo;
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
    public String getUcod() {
        return ucod;
    }
    public void setUcod(String ucod) {
        this.ucod = ucod;
    }

}

