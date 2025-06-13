package com.proyecto.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Pelicula;
import com.proyecto.demo1.Repository.PeliculaRepository;
import com.proyecto.demo1.dto.peliculaResumenDTO;
@Service
public class agregarPelicula {

    @Autowired
    private PeliculaRepository peliculaRepository;

    //genera nuevo codigo(P000x)
    public void añadirPelicula(Pelicula pelicula){
        if (pelicula.getId() == null || pelicula.getId().isEmpty()) {
            String ultimoCodigo = peliculaRepository.UltimoCodigo(); 

            int num = 1;
            if (ultimoCodigo != null && ultimoCodigo.startsWith("P")) {
                num = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
            }

            String nuevoCodigo = "P" + String.format("%04d", num); 
            pelicula.setId(nuevoCodigo);
        }

        peliculaRepository.save(pelicula);
    }

    //llama al repositorio
    public List<peliculaResumenDTO> getPeliculas(){
        return peliculaRepository.obtenerPeliculas();
    }
}
