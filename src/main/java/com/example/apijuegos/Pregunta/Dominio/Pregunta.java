package com.example.apijuegos.Pregunta.Dominio;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Pregunta pregunta = (Pregunta) o;
		return id != null && Objects.equals(id, pregunta.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}