package com.example.apijuegos.Ronda.Aplicacion;

import com.example.apijuegos.Ronda.Aplicacion.RondaImplException;
import com.example.apijuegos.Ronda.Aplicacion.RondaService;
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
		List<Ronda> rondaes = rondaRepository.findAll();
		return rondaMapper.listrondasEntityToModel(rondaes);
	}

	@Override
	public RondaModel save(RondaModel rondaModel) {
		// TODO Auto-generated method stub
		Ronda ronda = rondaMapper.rondaModeltoEntity(rondaModel);
		ronda = rondaRepository.save(ronda);
		return rondaMapper.rondaEntitytoModel(ronda);
	}

	@Override
	public RondaModel update(RondaDTO rondaDTO, Long id) throws RondaImplException {
		// TODO Auto-generated method stub
		Ronda ronda = rondaRepository.getById(id);
		RondaModel rondaModel = rondaMapper.rondaEntitytoModel(ronda);
		rondaModel.setNombre(rondaDTO.getNombre());
		return save(rondaModel);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		rondaRepository.deleteById(id);
	}

	@Override
	public RondaModel findById(Long id) throws RondaImplException {
		// TODO Auto-generated method stub
		Ronda ronda = rondaRepository.getById(id);
		return rondaMapper.rondaEntitytoModel(ronda);
	}

	@Override
	public RondaModel create(RondaDTO rondaDTO) throws RondaImplException {
		// TODO Auto-generated method stub
		RondaModel rondaModel = rondaMapper.rondaDTOtoModel(rondaDTO);
		return save(rondaModel);
	}
}
