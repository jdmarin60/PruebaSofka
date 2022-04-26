package com.example.apijuegos.Premio.Aplicacion;

import com.example.apijuegos.Premio.Dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioServiceImpl implements PremioService {

	@Autowired
	private PremioRepository premioRepository;
	
	@Autowired
	private PremioMapper premioMapper;

	@Override
	public List<PremioModel> findAll() {
		List<Premio> premios = premioRepository.findAll();
		return premioMapper.listpremiosEntityToModel(premios);
	}

	@Override
	public PremioModel save(PremioModel premioModel) {
		// TODO Auto-generated method stub
		Premio premio = premioMapper.premioModeltoEntity(premioModel);
		premio = premioRepository.save(premio);
		return premioMapper.premioEntitytoModel(premio);
	}

	@Override
	public PremioModel update(PremioDTO premioDTO, Long id) throws PremioImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PremioModel findById(Long id) throws PremioImplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PremioModel create(PremioDTO premioDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
