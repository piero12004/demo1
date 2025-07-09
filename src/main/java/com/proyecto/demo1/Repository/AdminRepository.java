package com.proyecto.demo1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.demo1.Model.Admin;  


public interface AdminRepository extends JpaRepository<Admin, String>{
    Admin findByAdminUsuario(String adminUsuario);

}
