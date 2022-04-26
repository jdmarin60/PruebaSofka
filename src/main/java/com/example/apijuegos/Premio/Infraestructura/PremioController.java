package com.example.apijuegos.Premio.Infraestructura;

import com.example.apijuegos.Premio.Aplicacion.PremioImplException;
import com.example.apijuegos.Premio.Aplicacion.PremioService;
import com.example.apijuegos.Premio.Dominio.PremioDTO;
import com.example.apijuegos.Premio.Dominio.PremioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PremioController {
	
	@Autowired
	private PremioService premioService;
	
	@GetMapping("/premios")
	public List<PremioModel> listarPremios() {
		return premioService.findAll();
	}
	
	@GetMapping("/premios/{id}")
	public PremioModel mostrarPremio(@PathVariable Long id) throws PremioImplException {
		return premioService.findById(id);
	}
	
	@PostMapping("/premios")
	@ResponseStatus(HttpStatus.CREATED)
	public PremioModel crearPremio (@RequestBody PremioDTO premioDTO) {
		return premioService.create(premioDTO);
	}
	
	@PutMapping("/premios/{id}")
	public PremioModel updatePremio (@RequestBody PremioDTO premioDTO, @PathVariable Long id) throws PremioImplException {
		return premioService.update(premioDTO, id);
	}
	
	@DeleteMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPremio (@PathVariable Long id) throws PremioImplException {
		premioService.deleteById(id);
	}
}