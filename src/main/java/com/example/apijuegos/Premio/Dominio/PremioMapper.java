package com.example.apijuegos.Premio.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class PremioMapper {
	
	public PremioModel premioEntitytoModel (Premio premio) {
		PremioModel premioModel = PremioModel.builder()
				.id(premio.getId())
				.valor(premio.getValor())
				.build();
		return premioModel;
	}
	
	public Premio premioModeltoEntity (PremioModel premioModel) {
		Premio premio = Premio.builder()
				.id(premioModel.getId())
				.valor(premioModel.getValor())
				.build();
		return premio;
	}
	
	public PremioModel premioDTOtoModel (PremioDTO premioDTO) {
		PremioModel premioModel = PremioModel.builder()
				.id(premioDTO.getId())
				.valor(premioDTO.getValor())
				.build();
		return premioModel;
	}
	
	public PremioDTO premioEntitytoDTO (Premio premio) {
		PremioDTO premioDTO = PremioDTO.builder()
				.id(premio.getId())
				.valor(premio.getValor())
				.build();
		return premioDTO;
	}
	
	public PremioDTO premioModeltoDTO (PremioModel premioModel) {
		PremioDTO premioDTO = PremioDTO.builder()
				.id(premioModel.getId())
				.valor(premioModel.getValor())
				.build();
		return premioDTO;
	}
	
	public Premio premioDTOtoEntity (PremioDTO premioDTO) {
		Premio premio = Premio.builder()
				.id(premioDTO.getId())
				.valor(premioDTO.getValor())
				.build();
		return premio;
	}

	public List<PremioModel> listpremiosEntityToModel (List<Premio> premios) {
		return premios.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<PremioModel> listpremiosDTOToModel (List<PremioDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Premio> listpremiosModelToEntity (List<PremioModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Premio> listpremiosDTOToEntity (List<PremioDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<PremioDTO> listpremiosEntityToDTO (List<Premio> premios) {
		return premios.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<PremioDTO> listpremiosModelToDTO (List<PremioModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoDTO)
				.collect(Collectors.toList());
	}
}
