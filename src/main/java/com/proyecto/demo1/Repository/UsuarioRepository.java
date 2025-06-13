package com.proyecto.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.demo1.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
@Query(value = "SELECT ucod FROM usuarios ORDER BY ucod DESC LIMIT 1", nativeQuery = true)
String findUltimoCodigo();
Usuario findByUsuarioAndContrasenia(String usuario, String contrasenia);

Usuario findByUcod(String ucod);

}
