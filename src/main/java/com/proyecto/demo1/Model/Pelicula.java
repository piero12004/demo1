package com.proyecto.demo1.Model;

public class Pelicula {
    private String nombreP;
    private String Img;

    public Pelicula(String nombreP, String Img){
        this.nombreP = nombreP;
        this.Img = Img;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    
}
