package com.example.apijuegos.Opcion.Aplicacion;

import com.example.apijuegos.Opcion.Dominio.OpcionDTO;
import com.example.apijuegos.Opcion.Dominio.OpcionModel;

import java.util.List;

public interface OpcionService {
	
	public List<OpcionModel> findAll();
	
	public OpcionModel save(OpcionModel opcionModel);
	
	public OpcionModel create(OpcionDTO opcionDTO);
	
	public OpcionModel update(OpcionDTO opcionDTO, Long id) throws OpcionImplException;
	
	public void deleteById(Long id) throws OpcionImplException;

	OpcionModel findById(Long id) throws OpcionImplException;
}
