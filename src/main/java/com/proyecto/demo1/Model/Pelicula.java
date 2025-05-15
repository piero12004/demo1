package com.proyecto.demo1.Model;

public class Pelicula {
    public static int contador = 100;
    private String nombreP;
    private String Img;
    private int peli_id;

    public int getPeli_id() {
        return peli_id;
    }

    public void asignarid_peli(){
        this.peli_id = contador++;
    }
    
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
