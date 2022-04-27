package com.example.apijuegos.Opcion.Dominio;

import com.example.apijuegos.Pregunta.Dominio.Pregunta;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "opciones")
public class Opcion implements Serializable {

	@Id
	@Column(name = "id_opcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@CreationTimestamp
	@Column(updatable = false)
	Timestamp dateCreated;

	@UpdateTimestamp
	Timestamp lastModified;
	/*
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Opcion opcion = (Opcion) o;
		return id != null && Objects.equals(id, opcion.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@ManyToMany(mappedBy = "opciones")
	private Collection<Pregunta> preguntas;

	public Collection<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Collection<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
}