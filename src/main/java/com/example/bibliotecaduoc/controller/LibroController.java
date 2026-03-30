package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listaLibros(){
        return ResponseEntity.ok(libroService.getLibros());
    }

    @GetMapping("/antiguos")
    public ResponseEntity<List<Libro>> listaMinFechaPublicacionLibros() {
        return ResponseEntity.ok(libroService.getMinFechaPublicacionLibros());
    }

    @GetMapping("/nuevos")
    public ResponseEntity<List<Libro>> listaMaxFechaPublicacionLibros() {
        return ResponseEntity.ok(libroService.getMaxFechaPublicacionLibros());
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<Libro>> listaLibrosOrdenados(){
        return ResponseEntity.ok(libroService.getLibrosOrgenados());
    }
    

    @PostMapping
    public ResponseEntity<?> agregaLibro(@Valid @RequestBody Libro libro){
	try {
		libroService.guardarLibro(libro);
		return ResponseEntity.status(HttpStatus.CREATED).body(libro);
	} catch (Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libro> buscarLibroPorIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(libroService.getLibroIsbn(isbn));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<Libro> buscarLibroPorAutor(@PathVariable String autor){
        return ResponseEntity.ok(libroService.getLibroAutor(autor));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<?> actualizarLibro(@Valid @RequestBody Libro libro){
        try {
		libroService.actualizarLibro(libro);
		return ResponseEntity.ok(libro);
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> eliminarLibro(@PathVariable String isbn){
	try {
		libroService.borrarLibro(isbn);
		return ResponseEntity.noContent().build();
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> totalLibros(){
        return ResponseEntity.ok(libroService.totalLibros());
    }

    @GetMapping("/total/{fechaPublicacion}")
    public ResponseEntity<Integer> totalLibros(@PathVariable int fechaPublicacion){
        return ResponseEntity.ok(libroService.totalLibros(fechaPublicacion));
    }

    
    

}