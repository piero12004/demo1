package com.proyecto.demo1.dto;

public class peliculaResumenDTO {
    private String cod;
    private String portada;
    private String titulo;

    public peliculaResumenDTO(String cod,String portada, String titulo){
        this.cod=cod;
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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    
}
