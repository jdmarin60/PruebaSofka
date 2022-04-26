package com.example.apijuegos.Opcion.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class OpcionMapper {
	
	public OpcionModel premioEntitytoModel (Opcion opcion) {
		OpcionModel opcionModel = OpcionModel.builder()
				.id(opcion.getId())
				.nombre(opcion.getNombre())
				.build();
		return opcionModel;
	}
	
	public Opcion premioModeltoEntity (OpcionModel opcionModel) {
		Opcion opcion = Opcion.builder()
				.id(opcionModel.getId())
				.nombre(opcionModel.getNombre())
				.build();
		return opcion;
	}
	
	public OpcionModel premioDTOtoModel (OpcionDTO opcionDTO) {
		OpcionModel opcionModel = OpcionModel.builder()
				.id(opcionDTO.getId())
				.nombre(opcionDTO.getNombre())
				.build();
		return opcionModel;
	}
	
	public OpcionDTO premioEntitytoDTO (Opcion opcion) {
		OpcionDTO opcionDTO = OpcionDTO.builder()
				.id(opcion.getId())
				.nombre(opcion.getNombre())
				.build();
		return opcionDTO;
	}
	
	public OpcionDTO premioModeltoDTO (OpcionModel opcionModel) {
		OpcionDTO opcionDTO = OpcionDTO.builder()
				.id(opcionModel.getId())
				.nombre(opcionModel.getNombre())
				.build();
		return opcionDTO;
	}
	
	public Opcion premioDTOtoEntity (OpcionDTO opcionDTO) {
		Opcion opcion = Opcion.builder()
				.id(opcionDTO.getId())
				.nombre(opcionDTO.getNombre())
				.build();
		return opcion;
	}

	public List<OpcionModel> listpremiosEntityToModel (List<Opcion> opciones) {
		return opciones.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<OpcionModel> listpremiosDTOToModel (List<OpcionDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Opcion> listpremiosModelToEntity (List<OpcionModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Opcion> listpremiosDTOToEntity (List<OpcionDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<OpcionDTO> listpremiosEntityToDTO (List<Opcion> opciones) {
		return opciones.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<OpcionDTO> listpremiosModelToDTO (List<OpcionModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoDTO)
				.collect(Collectors.toList());
	}
}
