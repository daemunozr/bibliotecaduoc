package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;

@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listaLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro){
        return libroService.guardarLibro(libro);
    }

    @GetMapping("{isbn}")
    public Libro buscarLibro(@PathVariable String isbn){
        return libroService.getLibroIsbn(isbn);
    }

    @PutMapping("{isbn}")
    public Libro actualizarLibro(@PathVariable String isbn, @RequestBody Libro libro){
        return libroService.actualizarLibro(libro);
    }

    @DeleteMapping("{isbn}")
    public String eliminarLibro(@PathVariable String isbn){
        return libroService.borrarLibro(isbn);
    }



    

}