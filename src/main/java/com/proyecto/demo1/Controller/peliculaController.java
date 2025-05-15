package com.proyecto.demo1.Controller;

//import java.nio.file.Path;
//import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.demo1.Model.Pelicula;
import com.proyecto.demo1.Service.agregarPelicula;

@Controller
public class peliculaController {
    private final agregarPelicula AgregarPelicula;

    public peliculaController(agregarPelicula AgregarPelicula){
        this.AgregarPelicula = AgregarPelicula;
    }

    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula, @RequestParam("urlP") MultipartFile urlP, Model model){
        String nombreArchivo = urlP.getOriginalFilename();
        
        pelicula.setImg("/imagenes/" + nombreArchivo);
        AgregarPelicula.añadirPelicula(pelicula);
        model.addAttribute("peliculas",AgregarPelicula.getPeliculas());
        return "cartelera";
    }

    @GetMapping("/AgregarPelicula")
    public String mostrarFormularioAgregarPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula("",""));
        return "agregarPelicula";
    }

    @GetMapping("/listaPeliculas")
    public String mostrarListaPeliculas(Model model){
        model.addAttribute("peliculas", AgregarPelicula.getPeliculas());
        return "listaPeliculas";
    }

    @PostMapping("/buscarPeli")
    public String buscarPelicula(@RequestParam int id, Model model){
        Pelicula peli = AgregarPelicula.obtenerPelixID(id);
        model.addAttribute("peliculas",AgregarPelicula.getPeliculas());
        model.addAttribute("resultado", peli);
        return "listaPeliculas";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarPelicula(@PathVariable int id){
        AgregarPelicula.eliminarPeli(id);
        return "redirect:/listaPeliculas";
    }
}

