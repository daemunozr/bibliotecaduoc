package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Libro> obtenerLibrosOrdenados(){
        List<Libro> tmp_libro = new ArrayList<>(listaLibros);
        tmp_libro.sort(Comparator.comparing(Libro::getFechaPublicacion));
        return tmp_libro;
    }

    public List<Libro> obtenerLibros(int fechaPublicacion){
        return listaLibros.
            stream().filter(libro -> libro.getFechaPublicacion() == fechaPublicacion). //return an object Libros matching conditional statement in filter
            collect(Collectors.toList());  //return an object List<T>
    }

    public List<Libro> obtenerPorMinFechaPublicacion(){
        int min_fecha_publicacion = Integer.MAX_VALUE;
        for(Libro libro: listaLibros){
            if(libro.getFechaPublicacion() < min_fecha_publicacion) min_fecha_publicacion = libro.getFechaPublicacion();
        }
        return obtenerLibros(min_fecha_publicacion);
    }

    public List<Libro> obtenerPorMaxFechaPublicacion(){
        int max_fecha_publicacion = Integer.MIN_VALUE;
        for(Libro libro: listaLibros){
            if(libro.getFechaPublicacion() > max_fecha_publicacion) max_fecha_publicacion = libro.getFechaPublicacion();
        }
        return obtenerLibros(max_fecha_publicacion);
    }
    public Libro buscarPorIsbn(String isbn){
        for(Libro libro : listaLibros){
            if(libro.getIsbn().equals(isbn)) return libro;
        }
        return null;
    }

    public Libro buscarPorAutor(String autor){
        for(Libro libro : listaLibros){
            if(libro.getAutor().equals(autor)) return libro;
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
