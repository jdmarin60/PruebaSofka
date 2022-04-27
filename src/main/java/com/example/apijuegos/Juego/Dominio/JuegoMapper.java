package com.example.apijuegos.Juego.Dominio;

import com.example.apijuegos.Juego.Dominio.Juego;
import com.example.apijuegos.Juego.Dominio.JuegoDTO;
import com.example.apijuegos.Juego.Dominio.JuegoModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class JuegoMapper {

	public JuegoModel juegoEntitytoModel (Juego juego) {
		JuegoModel juegoModel = JuegoModel.builder()
				.id(juego.getId())
				.preguntas(juego.getPreguntas())
				.rondas(juego.getRondas())
				.build();
		return juegoModel;
	}

	public JuegoModel juegoDTOtoModel (JuegoDTO juegoDTO) {
		JuegoModel juegoModel = JuegoModel.builder()
				.preguntas(juegoDTO.getPreguntas())
				.rondas(juegoDTO.getRondas())
				.build();
		return juegoModel;
	}

	public Juego juegoModeltoEntity (JuegoModel juegoModel) {
		Juego juego = Juego.builder()
				.id(juegoModel.getId())
				.preguntas(juegoModel.getPreguntas())
				.rondas(juegoModel.getRondas())
				.build();
		return juego;
	}

	public List<JuegoModel> listjuegosEntityToModel (List<Juego> juegoes) {
		return juegoes.stream()
				.filter(Objects::nonNull)
				.map(this::juegoEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Juego> listjuegosModelToEntity (List<JuegoModel> juegosModel) {
		return juegosModel.stream()
				.filter(Objects::nonNull)
				.map(this::juegoModeltoEntity)
				.collect(Collectors.toList());
	}
}
