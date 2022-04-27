package com.example.apijuegos.Categoria.Dominio;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class CategoriaMapper {
	
	public CategoriaModel premioEntitytoModel (Categoria categoria) {
		CategoriaModel categoriaModel = CategoriaModel.builder()
				.id(categoria.getId())
				.valor(categoria.getValor())
				.build();
		return categoriaModel;
	}
	
	public Categoria premioModeltoEntity (CategoriaModel categoriaModel) {
		Categoria categoria = Categoria.builder()
				.id(categoriaModel.getId())
				.valor(categoriaModel.getValor())
				.build();
		return categoria;
	}
	
	public CategoriaModel premioDTOtoModel (CategoriaDTO categoriaDTO) {
		CategoriaModel categoriaModel = CategoriaModel.builder()
				.id(categoriaDTO.getId())
				.valor(categoriaDTO.getValor())
				.build();
		return categoriaModel;
	}
	
	public CategoriaDTO premioEntitytoDTO (Categoria categoria) {
		CategoriaDTO categoriaDTO = CategoriaDTO.builder()
				.id(categoria.getId())
				.valor(categoria.getValor())
				.build();
		return categoriaDTO;
	}
	
	public CategoriaDTO premioModeltoDTO (CategoriaModel categoriaModel) {
		CategoriaDTO categoriaDTO = CategoriaDTO.builder()
				.id(categoriaModel.getId())
				.valor(categoriaModel.getValor())
				.build();
		return categoriaDTO;
	}
	
	public Categoria premioDTOtoEntity (CategoriaDTO categoriaDTO) {
		Categoria categoria = Categoria.builder()
				.id(categoriaDTO.getId())
				.valor(categoriaDTO.getValor())
				.build();
		return categoria;
	}

	public List<CategoriaModel> listpremiosEntityToModel (List<Categoria> categorias) {
		return categorias.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoModel)
				.collect(Collectors.toList());
	}
	
	public List<CategoriaModel> listpremiosDTOToModel (List<CategoriaDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoModel)
				.collect(Collectors.toList());
	}

	public List<Categoria> listpremiosModelToEntity (List<CategoriaModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoEntity)
				.collect(Collectors.toList());
	}
	
	public List<Categoria> listpremiosDTOToEntity (List<CategoriaDTO> premiosDTO) {
		return premiosDTO.stream()
				.filter(Objects::nonNull)
				.map(this::premioDTOtoEntity)
				.collect(Collectors.toList());
	}
	
	public List<CategoriaDTO> listpremiosEntityToDTO (List<Categoria> categorias) {
		return categorias.stream()
				.filter(Objects::nonNull)
				.map(this::premioEntitytoDTO)
				.collect(Collectors.toList());
	}

	public List<CategoriaDTO> listpremiosModelToDTO (List<CategoriaModel> premiosModel) {
		return premiosModel.stream()
				.filter(Objects::nonNull)
				.map(this::premioModeltoDTO)
				.collect(Collectors.toList());
	}
}
