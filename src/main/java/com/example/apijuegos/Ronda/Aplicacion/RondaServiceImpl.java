package com.example.apijuegos.Ronda.Aplicacion;

import com.example.apijuegos.Ronda.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RondaServiceImpl implements RondaService {

	@Autowired
	private RondaRepository rondaRepository;
	
	@Autowired
	private RondaMapper rondaMapper;

	@Override
	public List<RondaModel> findAll() {
		List<Ronda> rondas = rondaRepository.findAll();
		return rondaMapper.listpremiosEntityToModel(rondas);
	}

	@Override
	public RondaModel save(RondaModel rondaModel) {
		// TODO Auto-generated method stub
		Ronda ronda = rondaMapper.premioModeltoEntity(rondaModel);
		ronda = rondaRepository.save(ronda);
		return rondaMapper.premioEntitytoModel(ronda);
	}

	@Override
	public RondaModel update(RondaDTO rondaDTO, Long id) throws RondaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RondaModel findById(Long id) throws RondaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RondaModel create(RondaDTO rondaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
