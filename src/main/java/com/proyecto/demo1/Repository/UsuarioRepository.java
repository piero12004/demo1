package com.proyecto.demo1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.demo1.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    @Query(value = "SELECT ucod FROM usuarios ORDER BY ucod DESC LIMIT 1", nativeQuery = true)
    String findUltimoCodigo();
    Optional<Usuario> findByUsuario(String usuario);
    Usuario findByUcod(String ucod);
    Optional<Usuario> findByUsuarioAndRol(String usuario, String rol);
    List<Usuario> findAllByRol(String rol);

}
