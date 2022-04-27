package com.example.apijuegos.Pregunta.Aplicacion;

import com.example.apijuegos.Pregunta.Aplicacion.PreguntaImplException;
import com.example.apijuegos.Pregunta.Aplicacion.PreguntaService;
import com.example.apijuegos.Pregunta.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private PreguntaMapper preguntaMapper;

	@Override
	public List<PreguntaModel> findAll() {
		List<Pregunta> preguntaes = preguntaRepository.findAll();
		return preguntaMapper.listpreguntasEntityToModel(preguntaes);
	}

	@Override
	public PreguntaModel save(PreguntaModel preguntaModel) {
		// TODO Auto-generated method stub
		Pregunta pregunta = preguntaMapper.preguntaModeltoEntity(preguntaModel);
		pregunta = preguntaRepository.save(pregunta);
		return preguntaMapper.preguntaEntitytoModel(pregunta);
	}

	@Override
	public PreguntaModel update(PreguntaDTO preguntaDTO, Long id) throws PreguntaImplException {
		// TODO Auto-generated method stub
		Pregunta pregunta = preguntaRepository.getById(id);
		PreguntaModel preguntaModel = preguntaMapper.preguntaEntitytoModel(pregunta);
		preguntaModel.setEncabezado(preguntaDTO.getEncabezado());
		preguntaModel.setCategoria(preguntaDTO.getCategoria());
		pregunta.setOpciones(pregunta.getOpciones());
		return save(preguntaModel);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		preguntaRepository.deleteById(id);
	}

	@Override
	public PreguntaModel findById(Long id) throws PreguntaImplException {
		// TODO Auto-generated method stub
		Pregunta pregunta = preguntaRepository.getById(id);
		return preguntaMapper.preguntaEntitytoModel(pregunta);
	}

	@Override
	public PreguntaModel create(PreguntaDTO preguntaDTO) throws PreguntaImplException {
		// TODO Auto-generated method stub
		PreguntaModel preguntaModel = preguntaMapper.preguntaDTOtoModel(preguntaDTO);
		return save(preguntaModel);
	}
}
