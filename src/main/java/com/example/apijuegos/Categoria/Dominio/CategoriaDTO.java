package com.example.apijuegos.Categoria.Dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CategoriaDTO {
	private Long id;
	private String nombre;
}
