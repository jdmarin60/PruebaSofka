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
				.nombre(pregunta.getNombre())
				.telefono(pregunta.getTelefono())
				.build();
		return preguntaModel;
	}
	
	public Pregunta preguntaModeltoEntity (PreguntaModel preguntaModel) {
		Pregunta pregunta = Pregunta.builder()
				.id(preguntaModel.getId())
				.nombre(preguntaModel.getNombre())
				.telefono(preguntaModel.getTelefono())
				.build();
		return pregunta;
	}
	
	public PreguntaModel preguntaDTOtoModel (PreguntaDTO preguntaDTO) {
		PreguntaModel preguntaModel = PreguntaModel.builder()
				.id(preguntaDTO.getId())
				.nombre(preguntaDTO.getNombre())
				.telefono(preguntaDTO.getTelefono())
				.build();
		return preguntaModel;
	}
	
	public PreguntaDTO preguntaEntitytoDTO (Pregunta pregunta) {
		PreguntaDTO preguntaDTO = PreguntaDTO.builder()
				.id(pregunta.getId())
				.nombre(pregunta.getNombre())
				.telefono(pregunta.getTelefono())
				.build();
		return preguntaDTO;
	}
	
	public PreguntaDTO preguntaModeltoDTO (PreguntaModel preguntaModel) {
		PreguntaDTO preguntaDTO = PreguntaDTO.builder()
				.id(preguntaModel.getId())
				.nombre(preguntaModel.getNombre())
				.telefono(preguntaModel.getTelefono())
				.build();
		return preguntaDTO;
	}
	
	public Pregunta preguntaDTOtoEntity (PreguntaDTO preguntaDTO) {
		Pregunta pregunta = Pregunta.builder()
				.id(preguntaDTO.getId())
				.nombre(preguntaDTO.getNombre())
				.telefono(preguntaDTO.getTelefono())
				.build();
		return pregunta;
	}

	public List<PreguntaModel> listpreguntasEntityToModel (List<Pregunta> preguntas) {
		return preguntas.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<PreguntaModel> listpreguntasDTOToModel (List<PreguntaDTO> preguntasDTO) {
		return preguntasDTO.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Pregunta> listpreguntasModelToEntity (List<PreguntaModel> preguntasModel) {
		return preguntasModel.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Pregunta> listpreguntasDTOToEntity (List<PreguntaDTO> preguntasDTO) {
		return preguntasDTO.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<PreguntaDTO> listpreguntasEntityToDTO (List<Pregunta> preguntas) {
		return preguntas.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<PreguntaDTO> listpreguntasModelToDTO (List<PreguntaModel> preguntasModel) {
		return preguntasModel.stream()
				.filter(Objects::nonNull)
				.map(this::preguntaModeltoDTO)
				.collect(Collectors.toList());
	}
}
