package com.example.apijuegos.Juego.Infraestructura;

import com.example.apijuegos.Juego.Aplicacion.JuegoImplException;
import com.example.apijuegos.Juego.Aplicacion.JuegoService;
import com.example.apijuegos.Juego.Dominio.JuegoDTO;
import com.example.apijuegos.Juego.Dominio.JuegoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JuegoController {
	
	@Autowired
	private JuegoService juegoService;
	
	@GetMapping("/juegos")
	public ResponseEntity<List<JuegoModel>> listarJuegos() {
		List<JuegoModel> juegoModels = juegoService.findAll();
		if (juegoModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(juegoModels, HttpStatus.OK);
	}
	
	@GetMapping("/juegos/{id}")
	public ResponseEntity<JuegoModel> mostrarJuego(@PathVariable Long id) throws JuegoImplException {
		JuegoModel juegoModel = juegoService.findById(id);
		if (juegoModel == null) throw new JuegoImplException(JuegoImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(juegoModel, HttpStatus.OK);
	}
	
	@PostMapping("/juegos")
	public ResponseEntity<JuegoModel> crearJuego (@RequestBody JuegoDTO juegoDTO) throws JuegoImplException {
		JuegoModel juegoModel = juegoService.create(juegoDTO);
		if (juegoModel == null) throw new JuegoImplException(JuegoImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(juegoModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/juegos/{id}")
	public ResponseEntity<JuegoModel> updateJuego (@RequestBody JuegoDTO juegoDTO, @PathVariable Long id) throws JuegoImplException {
		JuegoModel juegoModel = juegoService.update(juegoDTO, id);
		if (juegoModel == null) throw new JuegoImplException(JuegoImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(juegoModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/juegos/{id}")
	public ResponseEntity<HttpStatus> borrarJuego (@PathVariable Long id) throws JuegoImplException {
		juegoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}