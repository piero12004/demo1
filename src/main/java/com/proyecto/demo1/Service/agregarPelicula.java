package com.proyecto.demo1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Pelicula;
@Service
public class agregarPelicula {
    private List <Pelicula> peliculas = new ArrayList<>();

    public void añadirPelicula(Pelicula pelicula){
        pelicula.asignarid_peli();
        peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas(){
        return this.peliculas;
    }

    public Pelicula obtenerPelixID(int id){
        return peliculas.stream().filter(p -> p.getPeli_id() == id)
        .findFirst()
        .orElse(null);
    }

    public void eliminarPeli(int id){
        Pelicula peli = obtenerPelixID(id);
        if(peli != null){
            peliculas.remove(peli);
        }
    }
}
