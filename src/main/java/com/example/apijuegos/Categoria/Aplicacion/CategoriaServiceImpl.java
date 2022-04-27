package com.example.apijuegos.Categoria.Aplicacion;

import com.example.apijuegos.Categoria.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaMapper categoriaMapper;

	@Override
	public List<CategoriaModel> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categoriaMapper.listpremiosEntityToModel(categorias);
	}

	@Override
	public CategoriaModel save(CategoriaModel categoriaModel) {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaMapper.premioModeltoEntity(categoriaModel);
		categoria = categoriaRepository.save(categoria);
		return categoriaMapper.premioEntitytoModel(categoria);
	}

	@Override
	public CategoriaModel update(CategoriaDTO categoriaDTO, Long id) throws CategoriaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaModel findById(Long id) throws CategoriaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaModel create(CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
