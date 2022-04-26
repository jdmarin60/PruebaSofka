package com.example.apijuegos.Pregunta.Aplicacion;

import com.example.apijuegos.Pregunta.Dominio.PreguntaDTO;
import com.example.apijuegos.Pregunta.Dominio.PreguntaModel;

import java.util.List;

public interface PreguntaService {
	
	public List<PreguntaModel> findAll();
	
	public PreguntaModel save(PreguntaModel preguntaModel);
	
	public PreguntaModel create(PreguntaDTO preguntaDTO);
	
	public PreguntaModel update(PreguntaDTO preguntaDTO, Long id) throws PreguntaImplException;
	
	public void deleteById(Long id) throws PreguntaImplException;

	PreguntaModel findById(Long id) throws PreguntaImplException;
}
