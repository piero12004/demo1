package com.proyecto.demo1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @Column(name = "admin_cod")
    private String adminCod;

    @Column(name = "admin_user")
    private String adminUsuario;

    @Column(name = "clave")
    private String adminClave;

    public String getAdminCod() {
        return adminCod;
    }

    public void setAdminCod(String adminCod) {
        this.adminCod = adminCod;
    }

    public String getAdminUsuario() {
        return adminUsuario;
    }

    public void setAdminUsuario(String adminUsuario) {
        this.adminUsuario = adminUsuario;
    }

    public String getAdminClave() {
        return adminClave;
    }

    public void setAdminClave(String adminClave) {
        this.adminClave = adminClave;
    }


    
}
