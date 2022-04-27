package com.example.apijuegos.Categoria.Dominio;

import com.example.apijuegos.Pregunta.Dominio.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CategoriaModel {
	private Long id;
	private String nombre;
	private Set<Pregunta> preguntas = new HashSet<>();
}
