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
		return opcionMapper.listopcionsEntityToModel(opciones);
	}

	@Override
	public OpcionModel save(OpcionModel opcionModel) {
		// TODO Auto-generated method stub
		Opcion opcion = opcionMapper.opcionModeltoEntity(opcionModel);
		opcion = opcionRepository.save(opcion);
		return opcionMapper.opcionEntitytoModel(opcion);
	}

	@Override
	public OpcionModel update(OpcionDTO opcionDTO, Long id) throws OpcionImplException {
		// TODO Auto-generated method stub
		Opcion opcion = opcionRepository.getById(id);
		OpcionModel opcionModel = opcionMapper.opcionEntitytoModel(opcion);
		opcionModel.setNombre(opcionDTO.getNombre());
		return save(opcionModel);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		opcionRepository.deleteById(id);
	}

	@Override
	public OpcionModel findById(Long id) throws OpcionImplException {
		// TODO Auto-generated method stub
		Opcion opcion = opcionRepository.getById(id);
		return opcionMapper.opcionEntitytoModel(opcion);
	}

	@Override
	public OpcionModel create(OpcionDTO opcionDTO) throws OpcionImplException {
		// TODO Auto-generated method stub
		OpcionModel opcionModel = opcionMapper.opcionDTOtoModel(opcionDTO);
		return save(opcionModel);
	}
}
