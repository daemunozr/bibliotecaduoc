package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;


@Repository
public class LibroRepository {
    private final List<Libro> listaLibros = new ArrayList<>();


    public LibroRepository(){
    }
    
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarPorIsbn(String isbn){
        for(Libro libro : listaLibros){
            if(libro.getIsbn().equals(isbn)) return libro;
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int posicion = 0;

        for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getIsbn().equals(lib.getIsbn())){
                posicion = i;
            }
        }
        Libro libro_tmp = new Libro(
            lib.getIsbn(),
            lib.getTitulo(),
            lib.getEditorial(),
            lib.getFechaPublicacion(),
            lib.getAutor()
        );

        listaLibros.set(posicion, libro_tmp);
        return libro_tmp;
    }

    public void eliminar(String isbn){
        Libro libro_tmp = buscarPorIsbn(isbn);
        if(libro_tmp != null) listaLibros.remove(libro_tmp);
    }
}
