package com.example.bibliotecaduoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro guardarLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibroIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }

    public Libro actualizarLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String borrarLibro(String isbn){
        libroRepository.eliminar(isbn);
        return "producto eliminado";
    }
}
