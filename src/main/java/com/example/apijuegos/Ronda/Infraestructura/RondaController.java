package com.example.apijuegos.Ronda.Infraestructura;

import com.example.apijuegos.Ronda.Aplicacion.RondaImplException;
import com.example.apijuegos.Ronda.Aplicacion.RondaService;
import com.example.apijuegos.Ronda.Dominio.RondaDTO;
import com.example.apijuegos.Ronda.Dominio.RondaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RondaController {
	
	@Autowired
	private RondaService rondaService;
	
	@GetMapping("/premios")
	public List<RondaModel> listarPremios() {
		return rondaService.findAll();
	}
	
	@GetMapping("/premios/{id}")
	public RondaModel mostrarPremio(@PathVariable Long id) throws RondaImplException {
		return rondaService.findById(id);
	}
	
	@PostMapping("/premios")
	@ResponseStatus(HttpStatus.CREATED)
	public RondaModel crearPremio (@RequestBody RondaDTO rondaDTO) {
		return rondaService.create(rondaDTO);
	}
	
	@PutMapping("/premios/{id}")
	public RondaModel updatePremio (@RequestBody RondaDTO rondaDTO, @PathVariable Long id) throws RondaImplException {
		return rondaService.update(rondaDTO, id);
	}
	
	@DeleteMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPremio (@PathVariable Long id) throws RondaImplException {
		rondaService.deleteById(id);
	}
}