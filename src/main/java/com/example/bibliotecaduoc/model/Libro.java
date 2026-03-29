package com.example.bibliotecaduoc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
	@NotBlank(message="El ISBN esta vacio")
	private String isbn;
	
	@NotBlank(message="El tiutlo esta vacio")
	private String titulo;

	@NotBlank(message="La editorial esta vacio")
	private String editorial;

	private int fechaPublicacion;
	private String autor;
}
