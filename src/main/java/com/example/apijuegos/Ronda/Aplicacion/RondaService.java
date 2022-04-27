package com.example.apijuegos.Ronda.Aplicacion;

import com.example.apijuegos.Ronda.Dominio.RondaDTO;
import com.example.apijuegos.Ronda.Dominio.RondaModel;

import java.util.List;

public interface RondaService {
	
	public List<RondaModel> findAll();
	
	public RondaModel save(RondaModel rondaModel);
	
	public RondaModel create(RondaDTO rondaDTO);
	
	public RondaModel update(RondaDTO rondaDTO, Long id) throws RondaImplException;
	
	public void deleteById(Long id) throws RondaImplException;

	RondaModel findById(Long id) throws RondaImplException;
}
