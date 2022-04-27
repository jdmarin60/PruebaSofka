package com.example.apijuegos.Juego.Aplicacion;

import com.example.apijuegos.Juego.Aplicacion.JuegoImplException;
import com.example.apijuegos.Juego.Aplicacion.JuegoService;
import com.example.apijuegos.Juego.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService {

	@Autowired
	private JuegoRepository juegoRepository;
	
	@Autowired
	private JuegoMapper juegoMapper;

	@Override
	public List<JuegoModel> findAll() {
		List<Juego> juegoes = juegoRepository.findAll();
		return juegoMapper.listjuegosEntityToModel(juegoes);
	}

	@Override
	public JuegoModel save(JuegoModel juegoModel) {
		// TODO Auto-generated method stub
		Juego juego = juegoMapper.juegoModeltoEntity(juegoModel);
		juego = juegoRepository.save(juego);
		return juegoMapper.juegoEntitytoModel(juego);
	}

	@Override
	public JuegoModel update(JuegoDTO juegoDTO, Long id) throws JuegoImplException {
		// TODO Auto-generated method stub
		Juego juego = juegoRepository.getById(id);
		JuegoModel juegoModel = juegoMapper.juegoEntitytoModel(juego);
		return save(juegoModel);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		juegoRepository.deleteById(id);
	}

	@Override
	public JuegoModel findById(Long id) throws JuegoImplException {
		// TODO Auto-generated method stub
		Juego juego = juegoRepository.getById(id);
		return juegoMapper.juegoEntitytoModel(juego);
	}

	@Override
	public JuegoModel create(JuegoDTO juegoDTO) throws JuegoImplException {
		// TODO Auto-generated method stub
		JuegoModel juegoModel = juegoMapper.juegoDTOtoModel(juegoDTO);
		return save(juegoModel);
	}
}
