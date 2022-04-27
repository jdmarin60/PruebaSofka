package com.example.apijuegos.Premio.Dominio;

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
@Table(name = "premios")
public class Premio implements Serializable {

	@Id
	@Column(name = "id_premio")
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
		Premio premio = (Premio) o;
		return id != null && Objects.equals(id, premio.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}