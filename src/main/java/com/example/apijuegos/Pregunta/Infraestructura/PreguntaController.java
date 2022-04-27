package com.example.apijuegos.Pregunta.Infraestructura;

import com.example.apijuegos.Pregunta.Aplicacion.PreguntaImplException;
import com.example.apijuegos.Pregunta.Aplicacion.PreguntaService;
import com.example.apijuegos.Pregunta.Dominio.PreguntaDTO;
import com.example.apijuegos.Pregunta.Dominio.PreguntaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PreguntaController {
	
	@Autowired
	private PreguntaService preguntaService;
	
	@GetMapping("/preguntas")
	public ResponseEntity<List<PreguntaModel>> listarPreguntas() {
		List<PreguntaModel> preguntaModels = preguntaService.findAll();
		if (preguntaModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(preguntaModels, HttpStatus.OK);
	}
	
	@GetMapping("/preguntas/{id}")
	public ResponseEntity<PreguntaModel> mostrarPregunta(@PathVariable Long id) throws PreguntaImplException {
		PreguntaModel preguntaModel = preguntaService.findById(id);
		if (preguntaModel == null) throw new PreguntaImplException(PreguntaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(preguntaModel, HttpStatus.OK);
	}
	
	@PostMapping("/preguntas")
	public ResponseEntity<PreguntaModel> crearPregunta (@RequestBody PreguntaDTO preguntaDTO) throws PreguntaImplException {
		PreguntaModel preguntaModel = preguntaService.create(preguntaDTO);
		if (preguntaModel == null) throw new PreguntaImplException(PreguntaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(preguntaModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/preguntas/{id}")
	public ResponseEntity<PreguntaModel> updatePregunta (@RequestBody PreguntaDTO preguntaDTO, @PathVariable Long id) throws PreguntaImplException {
		PreguntaModel preguntaModel = preguntaService.update(preguntaDTO, id);
		if (preguntaModel == null) throw new PreguntaImplException(PreguntaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(preguntaModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/preguntas/{id}")
	public ResponseEntity<HttpStatus> borrarPregunta (@PathVariable Long id) throws PreguntaImplException {
		preguntaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}