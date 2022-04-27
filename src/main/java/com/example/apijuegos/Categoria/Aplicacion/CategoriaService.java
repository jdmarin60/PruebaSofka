package com.example.apijuegos.Categoria.Aplicacion;

import com.example.apijuegos.Categoria.Dominio.CategoriaDTO;
import com.example.apijuegos.Categoria.Dominio.CategoriaModel;

import java.util.List;

public interface CategoriaService {
	
	public List<CategoriaModel> findAll();
	
	public CategoriaModel save(CategoriaModel categoriaModel);
	
	public CategoriaModel create(CategoriaDTO categoriaDTO);
	
	public CategoriaModel update(CategoriaDTO categoriaDTO, Long id) throws CategoriaImplException;
	
	public void deleteById(Long id) throws CategoriaImplException;

	CategoriaModel findById(Long id) throws CategoriaImplException;
}
