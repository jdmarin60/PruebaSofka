package com.example.apijuegos.Premio.Aplicacion;

import com.example.apijuegos.Premio.Dominio.PremioDTO;
import com.example.apijuegos.Premio.Dominio.PremioModel;

import java.util.List;

public interface PremioService {
	
	public List<PremioModel> findAll();
	
	public PremioModel save(PremioModel premioModel);
	
	public PremioModel create(PremioDTO premioDTO) throws PremioImplException;
	
	public PremioModel update(PremioDTO premioDTO, Long id) throws PremioImplException;
	
	public void deleteById(Long id) throws PremioImplException;

	PremioModel findById(Long id) throws PremioImplException;
}
