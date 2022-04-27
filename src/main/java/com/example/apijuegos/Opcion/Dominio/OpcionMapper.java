package com.example.apijuegos.Opcion.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class OpcionMapper {

	public OpcionModel opcionEntitytoModel (Opcion opcion) {
		OpcionModel opcionModel = OpcionModel.builder()
				.id(opcion.getId())
				.nombre(opcion.getNombre())
				.build();
		return opcionModel;
	}

	public OpcionModel opcionDTOtoModel (OpcionDTO opcionDTO) {
		OpcionModel opcionModel = OpcionModel.builder()
				.nombre(opcionDTO.getNombre())
				.build();
		return opcionModel;
	}

	public Opcion opcionModeltoEntity (OpcionModel opcionModel) {
		Opcion opcion = Opcion.builder()
				.id(opcionModel.getId())
				.nombre(opcionModel.getNombre())
				.build();
		return opcion;
	}

	public List<OpcionModel> listopcionesEntityToModel (List<Opcion> opciones) {
		return opciones.stream()
				.filter(Objects::nonNull)
				.map(this::opcionEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Opcion> listopcionesModelToEntity (List<OpcionModel> opcionsModel) {
		return opcionsModel.stream()
				.filter(Objects::nonNull)
				.map(this::opcionModeltoEntity)
				.collect(Collectors.toList());
	}
}
