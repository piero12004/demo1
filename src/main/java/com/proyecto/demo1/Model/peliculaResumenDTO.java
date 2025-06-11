package com.proyecto.demo1.Model;

public class peliculaResumenDTO {
    private String portada;
    private String titulo;

    public peliculaResumenDTO(String portada, String titulo){
        this.portada = portada;
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}
