package com.example.apijuegos.Opcion.Dominio;

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
@Builder(toBuilder = true)
@Table(name = "opciones")
public class Opcion implements Serializable {

	@Id
	@Column(name = "id_premio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
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
}