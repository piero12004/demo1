package com.proyecto.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.demo1.Model.Pelicula;
import com.proyecto.demo1.dto.peliculaResumenDTO;

public interface PeliculaRepository extends JpaRepository<Pelicula, String> {

@Query(value = "SELECT peli_cod FROM peliculas ORDER BY peli_cod DESC LIMIT 1", nativeQuery = true)
String UltimoCodigo();

//obtener datos (portada y titulo)
@Query("SELECT new com.proyecto.demo1.dto.peliculaResumenDTO(p.id, p.portada, p.titulo) FROM Pelicula p")
List<peliculaResumenDTO> obtenerPeliculas();

}
