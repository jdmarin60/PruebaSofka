package com.example.apijuegos.Juego.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class JuegoMapper {
	
	public JuegoModel premioEntitytoModel (Juego juego) {
		JuegoModel juegoModel = JuegoModel.builder()
				.id(juego.getId())
				.valor(juego.getValor())
				.build();
		return juegoModel;
	}
	
	public Juego premioModeltoEntity (JuegoModel juegoModel) {
		Juego juego = Juego.builder()
				.id(juegoModel.getId())
				.valor(juegoModel.getValor())
				.build();
		return juego;
	}
	
	public JuegoModel premioDTOtoModel (JuegoDTO juegoDTO) {
		JuegoModel juegoModel = JuegoModel.builder()
				.id(juegoDTO.getId())
				.valor(juegoDTO.getValor())
				.build();
		return juegoModel;
	}
	
	public JuegoDTO premioEntitytoDTO (Juego juego) {
		JuegoDTO juegoDTO = JuegoDTO.builder()
				.id(juego.getId())
				.valor(juego.getValor())
				.build();
		return juegoDTO;
	}
	
	public JuegoDTO premioModeltoDTO (JuegoModel juegoModel) {
		JuegoDTO juegoDTO = JuegoDTO.builder()
				.id(juegoModel.getId())
				.valor(juegoModel.getValor())
				.build();
		return juegoDTO;
	}
	
	public Juego premioDTOtoEntity (JuegoDTO juegoDTO) {
		Juego juego = Juego.builder()
				.id(juegoDTO.getId())
				.valor(juegoDTO.getValor())
				.build();
		return juego;
	}

	public List<JuegoModel> listpremiosEntityToModel (List<Juego> juegos) {
		return juegos.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<JuegoModel> listpremiosDTOToModel (List<JuegoDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Juego> listpremiosModelToEntity (List<JuegoModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Juego> listpremiosDTOToEntity (List<JuegoDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<JuegoDTO> listpremiosEntityToDTO (List<Juego> juegos) {
		return juegos.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<JuegoDTO> listpremiosModelToDTO (List<JuegoModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoDTO)
				.collect(Collectors.toList());
	}
}
