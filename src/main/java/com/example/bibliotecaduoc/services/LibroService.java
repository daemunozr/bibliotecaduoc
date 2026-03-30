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

	public List<Libro> getLibrosOrgenados(){
		return libroRepository.obtenerLibrosOrdenados();
	}

	public List<Libro> getMinFechaPublicacionLibros(){
		return libroRepository.obtenerPorMinFechaPublicacion();
	}

	public List<Libro> getMaxFechaPublicacionLibros(){
		return libroRepository.obtenerPorMaxFechaPublicacion();
	}
	public Libro guardarLibro(Libro libro) throws Exception{
		if(libroRepository.buscarPorIsbn(libro.getIsbn()) != null)
			throw new Exception("Error: Libro con ISBN " + libro.getIsbn() + "ya esta registrado");
		return libroRepository.guardar(libro);
	}

	public Libro getLibroIsbn(String isbn){
		return libroRepository.buscarPorIsbn(isbn);
	}

	public Libro getLibroAutor(String autor){
		return libroRepository.buscarPorAutor(autor);
	}

	public Libro actualizarLibro(Libro libro)throws Exception{

		if(libroRepository.buscarPorIsbn(libro.getIsbn()) == null)
			throw new Exception("Error: Libro no se encontro para actualizar");
		return libroRepository.actualizar(libro);
	}

	public String borrarLibro(String isbn) throws Exception{
		
		if(libroRepository.buscarPorIsbn(isbn) == null)
			throw new Exception("Error: Libro no se encontro para borrar");
		libroRepository.eliminar(isbn);
		return "producto eliminado";
	}

	public int totalLibros(){
		return libroRepository.obtenerLibros().size();
	}

	public int totalLibros(int fechaPublicacion){
		return libroRepository.obtenerLibros(fechaPublicacion).size(); // return size of List<T>
	}
}
