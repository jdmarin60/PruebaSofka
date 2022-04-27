package com.example.apijuegos.Ronda.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class RondaMapper {
	
	public RondaModel premioEntitytoModel (Ronda ronda) {
		RondaModel rondaModel = RondaModel.builder()
				.id(ronda.getId())
				.valor(ronda.getValor())
				.build();
		return rondaModel;
	}
	
	public Ronda premioModeltoEntity (RondaModel rondaModel) {
		Ronda ronda = Ronda.builder()
				.id(rondaModel.getId())
				.valor(rondaModel.getValor())
				.build();
		return ronda;
	}
	
	public RondaModel premioDTOtoModel (RondaDTO rondaDTO) {
		RondaModel rondaModel = RondaModel.builder()
				.id(rondaDTO.getId())
				.valor(rondaDTO.getValor())
				.build();
		return rondaModel;
	}
	
	public RondaDTO premioEntitytoDTO (Ronda ronda) {
		RondaDTO rondaDTO = RondaDTO.builder()
				.id(ronda.getId())
				.valor(ronda.getValor())
				.build();
		return rondaDTO;
	}
	
	public RondaDTO premioModeltoDTO (RondaModel rondaModel) {
		RondaDTO rondaDTO = RondaDTO.builder()
				.id(rondaModel.getId())
				.valor(rondaModel.getValor())
				.build();
		return rondaDTO;
	}
	
	public Ronda premioDTOtoEntity (RondaDTO rondaDTO) {
		Ronda ronda = Ronda.builder()
				.id(rondaDTO.getId())
				.valor(rondaDTO.getValor())
				.build();
		return ronda;
	}

	public List<RondaModel> listpremiosEntityToModel (List<Ronda> rondas) {
		return rondas.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<RondaModel> listpremiosDTOToModel (List<RondaDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Ronda> listpremiosModelToEntity (List<RondaModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Ronda> listpremiosDTOToEntity (List<RondaDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<RondaDTO> listpremiosEntityToDTO (List<Ronda> rondas) {
		return rondas.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<RondaDTO> listpremiosModelToDTO (List<RondaModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoDTO)
				.collect(Collectors.toList());
	}
}
