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
	
	@GetMapping("/rondas")
	public List<RondaModel> listarRondas() {
		return rondaService.findAll();
	}
	
	@GetMapping("/rondas/{id}")
	public RondaModel mostrarRonda(@PathVariable Long id) throws RondaImplException {
		return rondaService.findById(id);
	}
	
	@PostMapping("/rondas")
	@ResponseStatus(HttpStatus.CREATED)
	public RondaModel crearRonda (@RequestBody RondaDTO rondaDTO) {
		return rondaService.create(rondaDTO);
	}
	
	@PutMapping("/rondas/{id}")
	public RondaModel updateRonda (@RequestBody RondaDTO rondaDTO, @PathVariable Long id) throws RondaImplException {
		return rondaService.update(rondaDTO, id);
	}
	
	@DeleteMapping("/rondas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarRonda (@PathVariable Long id) throws RondaImplException {
		rondaService.deleteById(id);
	}
}