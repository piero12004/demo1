package com.proyecto.demo1.Controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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
import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.PeliculaRepository;
import com.proyecto.demo1.Repository.UsuarioRepository;
import com.proyecto.demo1.Service.agregarPelicula;

@Controller
public class peliculaController {
    @Autowired 
    private PeliculaRepository peliculaRepository;
    @Autowired
    private agregarPelicula agregarPelicula2;
    private final agregarPelicula AgregarPelicula;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public peliculaController(agregarPelicula AgregarPelicula){
        this.AgregarPelicula = AgregarPelicula;
    }

    //obtener y guardar datos de la pelicula
    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula, @RequestParam("urlP") MultipartFile urlP, Model model){
        String nombreArchivo = urlP.getOriginalFilename();
        
        pelicula.setPortada("/imagenes/" + nombreArchivo);
        AgregarPelicula.añadirPelicula(pelicula);
        model.addAttribute("peliculas", agregarPelicula2.getPeliculas());
        return "cartelera";
    }

    @GetMapping("/cartelera")
    public String mostrarCartelera(Model model, Principal principal) {
        // Lista de películas
        model.addAttribute("peliculas", agregarPelicula2.getPeliculas());

        // Si hay usuario logueado, obtener su ucod
        if (principal != null) {
            String username = principal.getName(); // nombre de usuario
            Optional<Usuario> usuarioOpt = usuarioRepository.findByUsuario(username);
            if (usuarioOpt.isPresent()) {
                model.addAttribute("usuarioLogueadoId", usuarioOpt.get().getUcod()); // lo que necesita el input hidden
                model.addAttribute("usuarioLogueado", usuarioOpt.get().getNombre()); // para mostrar el nombre
            }
        }

        return "cartelera";
    }


    @GetMapping("/admin/AgregarPelicula")
    public String mostrarFormularioAgregarPelicula(Model model) {
        model.addAttribute("pelicula", "");
        return "agregarPelicula";
    }

    @GetMapping("/admin/listaPeliculas")
    public String mostrarListaPeliculas(Model model){
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "listaPeliculas";
    }

    @PostMapping("/buscarPeli")
    public String buscarPelicula(@RequestParam String id, Model model){
        Optional<Pelicula> peli = peliculaRepository.findById(id);
        model.addAttribute("peliculas",peliculaRepository.findAll());
        model.addAttribute("resultado", peli.orElse(null));
        return "listaPeliculas";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarPelicula(@PathVariable String id){
        peliculaRepository.deleteById(id);
        return "redirect:/listaPeliculas";
    }


}

