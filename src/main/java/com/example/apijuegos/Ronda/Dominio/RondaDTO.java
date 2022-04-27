package com.example.apijuegos.Ronda.Dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class RondaDTO {
	private Long id;
	private Long valor;
}
