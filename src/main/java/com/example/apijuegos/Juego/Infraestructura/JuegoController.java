package com.example.apijuegos.Juego.Infraestructura;

import com.example.apijuegos.Juego.Aplicacion.JuegoImplException;
import com.example.apijuegos.Juego.Aplicacion.JuegoService;
import com.example.apijuegos.Juego.Dominio.JuegoDTO;
import com.example.apijuegos.Juego.Dominio.JuegoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class JuegoController {
	
	@Autowired
	private JuegoService juegoService;
	
	@GetMapping("/premios")
	public List<JuegoModel> listarPremios() {
		return juegoService.findAll();
	}
	
	@GetMapping("/premios/{id}")
	public JuegoModel mostrarPremio(@PathVariable Long id) throws JuegoImplException {
		return juegoService.findById(id);
	}
	
	@PostMapping("/premios")
	@ResponseStatus(HttpStatus.CREATED)
	public JuegoModel crearPremio (@RequestBody JuegoDTO juegoDTO) {
		return juegoService.create(juegoDTO);
	}
	
	@PutMapping("/premios/{id}")
	public JuegoModel updatePremio (@RequestBody JuegoDTO juegoDTO, @PathVariable Long id) throws JuegoImplException {
		return juegoService.update(juegoDTO, id);
	}
	
	@DeleteMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPremio (@PathVariable Long id) throws JuegoImplException {
		juegoService.deleteById(id);
	}
}