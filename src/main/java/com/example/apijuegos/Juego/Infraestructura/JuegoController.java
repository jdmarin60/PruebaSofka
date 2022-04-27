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
	
	@GetMapping("/juegos")
	public List<JuegoModel> listarJuegos() {
		return juegoService.findAll();
	}
	
	@GetMapping("/juegos/{id}")
	public JuegoModel mostrarJuego(@PathVariable Long id) throws JuegoImplException {
		return juegoService.findById(id);
	}
	
	@PostMapping("/juegos")
	@ResponseStatus(HttpStatus.CREATED)
	public JuegoModel crearJuego (@RequestBody JuegoDTO juegoDTO) {
		return juegoService.create(juegoDTO);
	}
	
	@PutMapping("/juegos/{id}")
	public JuegoModel updateJuego (@RequestBody JuegoDTO juegoDTO, @PathVariable Long id) throws JuegoImplException {
		return juegoService.update(juegoDTO, id);
	}
	
	@DeleteMapping("/juegos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarJuego (@PathVariable Long id) throws JuegoImplException {
		juegoService.deleteById(id);
	}
}