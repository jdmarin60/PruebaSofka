package com.example.apijuegos.Ronda.Dominio;

import com.example.apijuegos.Premio.Dominio.Premio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class RondaDTO {
	private String nombre;
	private Premio premio;
}
