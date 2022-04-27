package com.example.apijuegos.Pregunta.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class PreguntaMapper {
	
	public PreguntaModel preguntaEntitytoModel (Pregunta pregunta) {
		PreguntaModel preguntaModel = PreguntaModel.builder()
				.id(pregunta.getId())
				.encabezado(pregunta.getEncabezado())
				.opciones(pregunta.getOpciones())
				.build();
		return preguntaModel;
	}

	public PreguntaModel preguntaDTOtoModel (PreguntaDTO preguntaDTO) {
		PreguntaModel preguntaModel = PreguntaModel.builder()
				.encabezado(preguntaDTO.getEncabezado())
				.opciones(preguntaDTO.getOpciones())
				.build();
		return preguntaModel;
	}
	
	public Pregunta preguntaModeltoEntity (PreguntaModel preguntaModel) {
		Pregunta pregunta = Pregunta.builder()
				.id(preguntaModel.getId())
				.encabezado(preguntaModel.getEncabezado())
				.opciones(preguntaModel.getOpciones())
				.build();
		return pregunta;
	}

	public List<PreguntaModel> listpreguntasEntityToModel (List<Pregunta> preguntas) {
		return preguntas.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Pregunta> listpreguntasModelToEntity (List<PreguntaModel> preguntasModel) {
		return preguntasModel.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaModeltoEntity)
				.collect(Collectors.toList());
	}
}