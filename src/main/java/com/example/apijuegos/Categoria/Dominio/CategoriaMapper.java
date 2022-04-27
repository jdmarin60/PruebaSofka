package com.example.apijuegos.Categoria.Dominio;

import com.example.apijuegos.Categoria.Dominio.Categoria;
import com.example.apijuegos.Categoria.Dominio.CategoriaDTO;
import com.example.apijuegos.Categoria.Dominio.CategoriaModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class CategoriaMapper {

	public CategoriaModel categoriaEntitytoModel (Categoria categoria) {
		CategoriaModel categoriaModel = CategoriaModel.builder()
				.id(categoria.getId())
				.nombre(categoria.getNombre())
				.preguntas(categoria.getPreguntas())
				.build();
		return categoriaModel;
	}

	public CategoriaModel categoriaDTOtoModel (CategoriaDTO categoriaDTO) {
		CategoriaModel categoriaModel = CategoriaModel.builder()
				.nombre(categoriaDTO.getNombre())
				.build();
		return categoriaModel;
	}

	public Categoria categoriaModeltoEntity (CategoriaModel categoriaModel) {
		Categoria categoria = Categoria.builder()
				.id(categoriaModel.getId())
				.nombre(categoriaModel.getNombre())
				.build();
		return categoria;
	}

	public List<CategoriaModel> listcategoriasEntityToModel (List<Categoria> categoriaes) {
		return categoriaes.stream()
				.filter(Objects::nonNull)
				.map(this::categoriaEntitytoModel)
				.collect(Collectors.toList());
	}

	public List<Categoria> listcategoriasModelToEntity (List<CategoriaModel> categoriasModel) {
		return categoriasModel.stream()
				.filter(Objects::nonNull)
				.map(this::categoriaModeltoEntity)
				.collect(Collectors.toList());
	}
}
