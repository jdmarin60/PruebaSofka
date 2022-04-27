package com.example.apijuegos.Juego.Aplicacion;

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
		List<Juego> juegos = juegoRepository.findAll();
		return juegoMapper.listpremiosEntityToModel(juegos);
	}

	@Override
	public JuegoModel save(JuegoModel juegoModel) {
		// TODO Auto-generated method stub
		Juego juego = juegoMapper.premioModeltoEntity(juegoModel);
		juego = juegoRepository.save(juego);
		return juegoMapper.premioEntitytoModel(juego);
	}

	@Override
	public JuegoModel update(JuegoDTO juegoDTO, Long id) throws JuegoImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JuegoModel findById(Long id) throws JuegoImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JuegoModel create(JuegoDTO juegoDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
