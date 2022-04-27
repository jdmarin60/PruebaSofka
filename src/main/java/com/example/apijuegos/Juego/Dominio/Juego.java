package com.example.apijuegos.Juego.Dominio;

import com.example.apijuegos.Categoria.Dominio.Categoria;
import com.example.apijuegos.Opcion.Dominio.Opcion;
import com.example.apijuegos.Pregunta.Dominio.Pregunta;
import com.example.apijuegos.Ronda.Dominio.Ronda;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
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
@Table(name = "juegos")
public class Juego implements Serializable {

	@Id
	@Column(name = "id_juego")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(
			name = "juego_pregunta",
			joinColumns = @JoinColumn(name = "id_juego"),
			inverseJoinColumns = @JoinColumn(name = "id_pregunta"))
	private Set<Pregunta> preguntas = new HashSet<>();

	@ManyToMany(mappedBy = "juegos")
	private Collection<Ronda> rondas;

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
		Juego juego = (Juego) o;
		return id != null && Objects.equals(id, juego.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Collection<Ronda> getRondas() {
		return rondas;
	}

	public void setRondas(Collection<Ronda> rondas) {
		this.rondas = rondas;
	}
}