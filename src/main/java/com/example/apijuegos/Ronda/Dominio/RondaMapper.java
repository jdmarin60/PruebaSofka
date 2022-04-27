package com.example.apijuegos.Ronda.Dominio;

import com.example.apijuegos.Ronda.Dominio.Ronda;
import com.example.apijuegos.Ronda.Dominio.RondaDTO;
import com.example.apijuegos.Ronda.Dominio.RondaModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class RondaMapper {

	public RondaModel rondaEntitytoModel (Ronda ronda) {
		RondaModel rondaModel = RondaModel.builder()
				.id(ronda.getId())
				.nombre(ronda.getNombre())
				.premio(ronda.getPremio())
				.build();
		return rondaModel;
	}

	public RondaModel rondaDTOtoModel (RondaDTO rondaDTO) {
		RondaModel rondaModel = RondaModel.builder()
				.nombre(rondaDTO.getNombre())
				.premio(rondaDTO.getPremio())
				.build();
		return rondaModel;
	}

	public Ronda rondaModeltoEntity (RondaModel rondaModel) {
		Ronda ronda = Ronda.builder()
				.id(rondaModel.getId())
				.nombre(rondaModel.getNombre())
				.premio(rondaModel.getPremio())
				.build();
		return ronda;
	}

	public List<RondaModel> listrondasEntityToModel (List<Ronda> rondaes) {
		return rondaes.stream()
				.filter(Objects::nonNull)
				.map(this::rondaEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Ronda> listrondasModelToEntity (List<RondaModel> rondasModel) {
		return rondasModel.stream()
				.filter(Objects::nonNull)
				.map(this::rondaModeltoEntity)
				.collect(Collectors.toList());
	}
}
