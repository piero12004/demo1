package com.proyecto.demo1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Pelicula;
@Service
public class agregarPelicula {
    private List <Pelicula> peliculas = new ArrayList<>();

    public void añadirPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas(){
        return this.peliculas;
    }
}
