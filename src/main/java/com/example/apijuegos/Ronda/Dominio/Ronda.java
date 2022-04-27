package com.example.apijuegos.Ronda.Dominio;

import com.example.apijuegos.Juego.Dominio.Juego;
import com.example.apijuegos.Opcion.Dominio.Opcion;
import com.example.apijuegos.Pregunta.Dominio.Pregunta;
import com.example.apijuegos.Premio.Dominio.Premio;
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
@Table(name = "rondas")
public class Ronda implements Serializable {

	@Id
	@Column(name = "id_ronda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	@OneToOne
	@JoinColumn(name = "id_premio")
	private Premio premio;

	@ManyToMany
	@JoinTable(
			name = "juego_ronda",
			joinColumns = @JoinColumn(name = "id_ronda"),
			inverseJoinColumns = @JoinColumn(name = "id_juego"))
	private Set<Juego> juegos = new HashSet<>();

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
		Ronda ronda = (Ronda) o;
		return id != null && Objects.equals(id, ronda.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}