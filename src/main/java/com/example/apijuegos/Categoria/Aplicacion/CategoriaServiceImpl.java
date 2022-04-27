package com.example.apijuegos.Categoria.Aplicacion;

import com.example.apijuegos.Categoria.Aplicacion.CategoriaImplException;
import com.example.apijuegos.Categoria.Aplicacion.CategoriaService;
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
		List<Categoria> categoriaes = categoriaRepository.findAll();
		return categoriaMapper.listcategoriasEntityToModel(categoriaes);
	}

	@Override
	public CategoriaModel save(CategoriaModel categoriaModel) {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaMapper.categoriaModeltoEntity(categoriaModel);
		categoria = categoriaRepository.save(categoria);
		return categoriaMapper.categoriaEntitytoModel(categoria);
	}

	@Override
	public CategoriaModel update(CategoriaDTO categoriaDTO, Long id) throws CategoriaImplException {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaRepository.getById(id);
		CategoriaModel categoriaModel = categoriaMapper.categoriaEntitytoModel(categoria);
		categoriaModel.setNombre(categoriaDTO.getNombre());
		return save(categoriaModel);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

	@Override
	public CategoriaModel findById(Long id) throws CategoriaImplException {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaRepository.getById(id);
		return categoriaMapper.categoriaEntitytoModel(categoria);
	}

	@Override
	public CategoriaModel create(CategoriaDTO categoriaDTO) throws CategoriaImplException {
		// TODO Auto-generated method stub
		CategoriaModel categoriaModel = categoriaMapper.categoriaDTOtoModel(categoriaDTO);
		return save(categoriaModel);
	}
}
