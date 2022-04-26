package com.example.apijuegos.Opcion.Aplicacion;

import com.example.apijuegos.Opcion.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionServiceImpl implements OpcionService {

	@Autowired
	private OpcionRepository opcionRepository;
	
	@Autowired
	private OpcionMapper opcionMapper;

	@Override
	public List<OpcionModel> findAll() {
		List<Opcion> opciones = opcionRepository.findAll();
		return opcionMapper.listpremiosEntityToModel(opciones);
	}

	@Override
	public OpcionModel save(OpcionModel opcionModel) {
		// TODO Auto-generated method stub
		Opcion opcion = opcionMapper.premioModeltoEntity(opcionModel);
		opcion = opcionRepository.save(opcion);
		return opcionMapper.premioEntitytoModel(opcion);
	}

	@Override
	public OpcionModel update(OpcionDTO opcionDTO, Long id) throws OpcionImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OpcionModel findById(Long id) throws OpcionImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcionModel create(OpcionDTO opcionDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
