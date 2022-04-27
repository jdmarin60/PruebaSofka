package com.example.apijuegos.Pregunta.Dominio;

import com.example.apijuegos.Opcion.Dominio.Opcion;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@Table(name = "preguntas")
public class Pregunta implements Serializable {

	@Id
	@Column(name = "id_pregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String encabezado;

	@ManyToMany
	@JoinTable(
			name = "pregunta_opcion",
			joinColumns = @JoinColumn(name = "id_pregunta"),
			inverseJoinColumns = @JoinColumn(name = "id_opcion"))
	private Set<Opcion> opciones = new HashSet<>();

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp dateCreated;

	@UpdateTimestamp
	private Timestamp lastModified;
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