package com.example.apijuegos.Juego.Dominio;

import com.example.apijuegos.Pregunta.Dominio.Pregunta;
import com.example.apijuegos.Ronda.Dominio.Ronda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class JuegoModel {
	private Long id;
	private Set<Pregunta> preguntas = new HashSet<>();
	private Collection<Ronda> rondas;
}
