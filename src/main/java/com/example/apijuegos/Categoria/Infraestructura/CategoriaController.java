package com.example.apijuegos.Categoria.Infraestructura;

import com.example.apijuegos.Categoria.Aplicacion.CategoriaImplException;
import com.example.apijuegos.Categoria.Aplicacion.CategoriaService;
import com.example.apijuegos.Categoria.Dominio.CategoriaDTO;
import com.example.apijuegos.Categoria.Dominio.CategoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public ResponseEntity<List<CategoriaModel>> listarCategorias() {
		List<CategoriaModel> categoriaModels = categoriaService.findAll();
		if (categoriaModels.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(categoriaModels, HttpStatus.OK);
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaModel> mostrarCategoria(@PathVariable Long id) throws CategoriaImplException {
		CategoriaModel categoriaModel = categoriaService.findById(id);
		if (categoriaModel == null) throw new CategoriaImplException(CategoriaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(categoriaModel, HttpStatus.OK);
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<CategoriaModel> crearCategoria (@RequestBody CategoriaDTO categoriaDTO) throws CategoriaImplException {
		CategoriaModel categoriaModel = categoriaService.create(categoriaDTO);
		if (categoriaModel == null) throw new CategoriaImplException(CategoriaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(categoriaModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<CategoriaModel> updateCategoria (@RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) throws CategoriaImplException {
		CategoriaModel categoriaModel = categoriaService.update(categoriaDTO, id);
		if (categoriaModel == null) throw new CategoriaImplException(CategoriaImplException.ENTIDAD_NO_ENCONTRADA);
		return new ResponseEntity<>(categoriaModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<HttpStatus> borrarCategoria (@PathVariable Long id) throws CategoriaImplException {
		categoriaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}