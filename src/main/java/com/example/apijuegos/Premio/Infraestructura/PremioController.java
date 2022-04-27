package com.example.apijuegos.Premio.Infraestructura;

import com.example.apijuegos.Premio.Aplicacion.PremioImplException;
import com.example.apijuegos.Premio.Aplicacion.PremioService;
import com.example.apijuegos.Premio.Dominio.PremioDTO;
import com.example.apijuegos.Premio.Dominio.PremioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PremioController {
	
	@Autowired
	private PremioService premioService;
	
	@GetMapping("/premios")
	public ResponseEntity<List<PremioModel>> listarPremios() {
		List<PremioModel> premioModels = premioService.findAll();
		if (premioModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(premioModels, HttpStatus.OK);
	}
	
	@GetMapping("/premios/{id}")
	public ResponseEntity<PremioModel> mostrarPremio(@PathVariable Long id) throws PremioImplException {
		PremioModel premioModel = premioService.findById(id);
		if (premioModel == null) throw new PremioImplException(PremioImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(premioModel, HttpStatus.OK);
	}
	
	@PostMapping("/premios")
	public ResponseEntity<PremioModel> crearPremio (@RequestBody PremioDTO premioDTO) throws PremioImplException {
		PremioModel premioModel = premioService.create(premioDTO);
		if (premioModel == null) throw new PremioImplException(PremioImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(premioModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/premios/{id}")
	public ResponseEntity<PremioModel> updatePremio (@RequestBody PremioDTO premioDTO, @PathVariable Long id) throws PremioImplException {
		PremioModel premioModel = premioService.update(premioDTO, id);
		if (premioModel == null) throw new PremioImplException(PremioImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(premioModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/premios/{id}")
	public ResponseEntity<HttpStatus> borrarPremio (@PathVariable Long id) throws PremioImplException {
		premioService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}