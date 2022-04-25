package com.example.apijuegos.Pregunta.Aplicacion;

import com.example.apijuegos.Pregunta.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaRepository PreguntaRepository;
	
	@Autowired
	private PreguntaMapper PreguntaMapper;

	@Override
	public List<PreguntaModel> findAll() {
		List<Pregunta> Preguntas = PreguntaRepository.findAll();
		return PreguntaMapper.listpreguntasEntityToModel(Preguntas);
	}

	@Override
	public PreguntaModel save(PreguntaModel PreguntaModel) {
		// TODO Auto-generated method stub
		Pregunta Pregunta = PreguntaMapper.preguntaModeltoEntity(PreguntaModel);
		Pregunta = PreguntaRepository.save(Pregunta); 
		return PreguntaMapper.preguntaEntitytoModel(Pregunta);
	}
	
	

	@Override
	public PreguntaModel update(PreguntaDTO PreguntaDTO, Long id) throws PreguntaImplException {
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
	public PreguntaModel create(PreguntaDTO PreguntaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
