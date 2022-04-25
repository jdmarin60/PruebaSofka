package com.example.apijuegos.Pregunta.Dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class PreguntaDTO {
	private Long id;
	private Long telefono;
	private String nombre;
}
