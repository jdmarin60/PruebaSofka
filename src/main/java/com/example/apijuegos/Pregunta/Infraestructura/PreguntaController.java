package com.example.apijuegos.Pregunta.Infraestructura;

import com.example.apijuegos.Pregunta.Aplicacion.PreguntaImplException;
import com.example.apijuegos.Pregunta.Aplicacion.PreguntaService;
import com.example.apijuegos.Pregunta.Dominio.PreguntaDTO;
import com.example.apijuegos.Pregunta.Dominio.PreguntaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PreguntaController {
	
	@Autowired
	private PreguntaService PreguntaService;
	
	@GetMapping("/preguntas")
	public List<PreguntaModel> listarPreguntas() {
		return PreguntaService.findAll();
	}
	
	@GetMapping("/preguntas/{id}")
	public PreguntaModel mostrarPregunta(@PathVariable Long id) throws PreguntaImplException {
		return PreguntaService.findById(id);
	}
	
	@PostMapping("/preguntas")
	@ResponseStatus(HttpStatus.CREATED)
	public PreguntaModel crearPregunta (@RequestBody PreguntaDTO PreguntaDTO) {
		return PreguntaService.create(PreguntaDTO);
	}
	
	@PutMapping("/preguntas/{id}")
	public PreguntaModel updatePregunta (@RequestBody PreguntaDTO PreguntaDTO, @PathVariable Long id) throws PreguntaImplException {
		return PreguntaService.update(PreguntaDTO, id);
	}
	
	@DeleteMapping("/preguntas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPregunta (@PathVariable Long id) throws PreguntaImplException {
		PreguntaService.deleteById(id);
	}
}