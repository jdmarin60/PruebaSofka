package com.example.apijuegos.Juego.Aplicacion;

import com.example.apijuegos.Juego.Dominio.JuegoDTO;
import com.example.apijuegos.Juego.Dominio.JuegoModel;

import java.util.List;

public interface JuegoService {
	
	public List<JuegoModel> findAll();
	
	public JuegoModel save(JuegoModel juegoModel);
	
	public JuegoModel create(JuegoDTO juegoDTO);
	
	public JuegoModel update(JuegoDTO juegoDTO, Long id) throws JuegoImplException;
	
	public void deleteById(Long id) throws JuegoImplException;

	JuegoModel findById(Long id) throws JuegoImplException;
}
