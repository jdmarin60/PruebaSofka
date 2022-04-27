package com.example.apijuegos.Juego.Dominio;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

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

	private Long valor;

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
}