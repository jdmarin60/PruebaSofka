package com.example.apijuegos.Pregunta.Dominio;

import com.example.apijuegos.Opcion.Dominio.Opcion;
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
public class PreguntaModel {
	private Long id;
	private String encabezado;
	private Set<Opcion> opciones = new HashSet<>();
}
