package com.example.apijuegos.Pregunta.Dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Table(name = "preguntas")
public class Pregunta implements Serializable {

	@Id
	@Column(name = "id_pregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "telefono", length = 20, nullable = false)
	private Long telefono;

	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	/*
	 */
	private static final long serialVersionUID = 1L;

}