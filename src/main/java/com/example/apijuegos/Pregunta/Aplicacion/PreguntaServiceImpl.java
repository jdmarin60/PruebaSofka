package com.example.apijuegos.Pregunta.Aplicacion;

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
		List<Pregunta> preguntas = preguntaRepository.findAll();
		return preguntaMapper.listpreguntasEntityToModel(preguntas);
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
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreguntaModel findById(Long id) throws PreguntaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreguntaModel create(PreguntaDTO preguntaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
