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

    public Libro buscarPorId(int id){
        for(Libro libro : listaLibros){
            if(libro.getId() == id) return libro;
        }
        return null;
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
        int id = 0;
        int idPosicion = 0;

        for(int i=0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        Libro libro_tmp = new Libro(
            id,
            lib.getIsbn(),
            lib.getTitulo(),
            lib.getEditorial(),
            lib.getFechaPublicacion(),
            lib.getAutor()
        );

        listaLibros.set(idPosicion, libro_tmp);
        return libro_tmp;
    }

    public void eliminar(int id){
        Libro libro_tmp = buscarPorId(id);
        if(libro_tmp != null) listaLibros.remove(libro_tmp);
    }
}
