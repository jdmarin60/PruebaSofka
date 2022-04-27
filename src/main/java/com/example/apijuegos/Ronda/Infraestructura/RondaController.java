package com.example.apijuegos.Ronda.Infraestructura;

import com.example.apijuegos.Ronda.Aplicacion.RondaImplException;
import com.example.apijuegos.Ronda.Aplicacion.RondaService;
import com.example.apijuegos.Ronda.Dominio.RondaDTO;
import com.example.apijuegos.Ronda.Dominio.RondaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RondaController {
	
	@Autowired
	private RondaService rondaService;
	
	@GetMapping("/rondas")
	public ResponseEntity<List<RondaModel>> listarRondas() {
		List<RondaModel> rondaModels = rondaService.findAll();
		if (rondaModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(rondaModels, HttpStatus.OK);
	}
	
	@GetMapping("/rondas/{id}")
	public ResponseEntity<RondaModel> mostrarRonda(@PathVariable Long id) throws RondaImplException {
		RondaModel rondaModel = rondaService.findById(id);
		if (rondaModel == null) throw new RondaImplException(RondaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(rondaModel, HttpStatus.OK);
	}
	
	@PostMapping("/rondas")
	public ResponseEntity<RondaModel> crearRonda (@RequestBody RondaDTO rondaDTO) throws RondaImplException {
		RondaModel rondaModel = rondaService.create(rondaDTO);
		if (rondaModel == null) throw new RondaImplException(RondaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(rondaModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/rondas/{id}")
	public ResponseEntity<RondaModel> updateRonda (@RequestBody RondaDTO rondaDTO, @PathVariable Long id) throws RondaImplException {
		RondaModel rondaModel = rondaService.update(rondaDTO, id);
		if (rondaModel == null) throw new RondaImplException(RondaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(rondaModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/rondas/{id}")
	public ResponseEntity<HttpStatus> borrarRonda (@PathVariable Long id) throws RondaImplException {
		rondaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}