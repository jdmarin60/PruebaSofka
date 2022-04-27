package com.example.apijuegos.Opcion.Infraestructura;

import com.example.apijuegos.Opcion.Aplicacion.OpcionImplException;
import com.example.apijuegos.Opcion.Aplicacion.OpcionService;
import com.example.apijuegos.Opcion.Dominio.OpcionDTO;
import com.example.apijuegos.Opcion.Dominio.OpcionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OpcionController {
	
	@Autowired
	private OpcionService opcionService;
	
	@GetMapping("/opciones")
	public ResponseEntity<List<OpcionModel>> listarOpcions() {
		List<OpcionModel> opcionModels = opcionService.findAll();
		if (opcionModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(opcionModels, HttpStatus.OK);
	}
	
	@GetMapping("/opciones/{id}")
	public ResponseEntity<OpcionModel> mostrarOpcion(@PathVariable Long id) throws OpcionImplException {
		OpcionModel opcionModel = opcionService.findById(id);
		if (opcionModel == null) throw new OpcionImplException(OpcionImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(opcionModel, HttpStatus.OK);
	}
	
	@PostMapping("/opciones")
	public ResponseEntity<OpcionModel> crearOpcion (@RequestBody OpcionDTO opcionDTO) throws OpcionImplException {
		OpcionModel opcionModel = opcionService.create(opcionDTO);
		if (opcionModel == null) throw new OpcionImplException(OpcionImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(opcionModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/opciones/{id}")
	public ResponseEntity<OpcionModel> updateOpcion (@RequestBody OpcionDTO opcionDTO, @PathVariable Long id) throws OpcionImplException {
		OpcionModel opcionModel = opcionService.update(opcionDTO, id);
		if (opcionModel == null) throw new OpcionImplException(OpcionImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(opcionModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/opciones/{id}")
	public ResponseEntity<HttpStatus> borrarOpcion (@PathVariable Long id) throws OpcionImplException {
		opcionService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}