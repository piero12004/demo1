package com.proyecto.demo1.Model;

public class Usuario {
    public static int contador=100;
    private int id;
    private String usuario;
    private String contrasenia;

    public Usuario(String usuario, String contrasenia) {
        this.id = contador++;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    public int getId() {
        return id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    

}
