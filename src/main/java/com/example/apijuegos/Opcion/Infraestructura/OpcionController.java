package com.example.apijuegos.Opcion.Infraestructura;

import com.example.apijuegos.Opcion.Aplicacion.OpcionImplException;
import com.example.apijuegos.Opcion.Aplicacion.OpcionService;
import com.example.apijuegos.Opcion.Dominio.OpcionDTO;
import com.example.apijuegos.Opcion.Dominio.OpcionModel;
import com.example.apijuegos.Opcion.Infraestructura.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class OpcionController {
	
	@Autowired
	private OpcionService opcionService;
	
	@GetMapping("/opciones")
	public List<OpcionModel> listarPremios() {
		return opcionService.findAll();
	}
	
	@GetMapping("/opciones/{id}")
	public OpcionModel mostrarPremio(@PathVariable Long id) throws OpcionImplException {
		return opcionService.findById(id);
	}
	
	@PostMapping("/opciones")
	public ResponseEntity<OpcionModel> crearPremio (@RequestBody OpcionDTO opcionDTO) throws BadRequestAlertException {
		OpcionModel opcionModel = opcionService.create(opcionDTO);
		if (opcionModel == null) throw new BadRequestAlertException(BadRequestAlertException.ENTIDAD_NO_ENCONTRADO);
		return new ResponseEntity<>(opcionModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/opciones/{id}")
	public OpcionModel updatePremio (@RequestBody OpcionDTO opcionDTO, @PathVariable Long id) throws OpcionImplException {
		return opcionService.update(opcionDTO, id);
	}
	
	@DeleteMapping("/opciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPremio (@PathVariable Long id) throws OpcionImplException {
		opcionService.deleteById(id);
	}
}