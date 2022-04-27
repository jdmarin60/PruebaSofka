package com.example.apijuegos.Premio.Dominio;

import com.example.apijuegos.Premio.Dominio.Premio;
import com.example.apijuegos.Premio.Dominio.PremioDTO;
import com.example.apijuegos.Premio.Dominio.PremioModel;
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

	public PremioModel premioDTOtoModel (PremioDTO premioDTO) {
		PremioModel premioModel = PremioModel.builder()
				.valor(premioDTO.getValor())
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

	public List<PremioModel> listpremiosEntityToModel (List<Premio> premioes) {
		return premioes.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Premio> listpremiosModelToEntity (List<PremioModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
}
