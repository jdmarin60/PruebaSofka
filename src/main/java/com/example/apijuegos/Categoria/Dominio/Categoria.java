package com.example.apijuegos.Categoria.Dominio;

import com.example.apijuegos.Opcion.Dominio.Opcion;
import com.example.apijuegos.Pregunta.Dominio.Pregunta;
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
@Table(name = "categorias")
public class Categoria implements Serializable {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany(mappedBy = "categoria")
	private Set<Pregunta> preguntas = new HashSet<>();

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
		Categoria categoria = (Categoria) o;
		return id != null && Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}