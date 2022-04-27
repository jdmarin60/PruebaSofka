package com.example.apijuegos.Categoria.Infraestructura;

import com.example.apijuegos.Categoria.Aplicacion.CategoriaImplException;
import com.example.apijuegos.Categoria.Aplicacion.CategoriaService;
import com.example.apijuegos.Categoria.Dominio.CategoriaDTO;
import com.example.apijuegos.Categoria.Dominio.CategoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<CategoriaModel> listarCategorias() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	public CategoriaModel mostrarCategoria(@PathVariable Long id) throws CategoriaImplException {
		return categoriaService.findById(id);
	}
	
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaModel crearCategoria (@RequestBody CategoriaDTO categoriaDTO) {
		return categoriaService.create(categoriaDTO);
	}
	
	@PutMapping("/categorias/{id}")
	public CategoriaModel updateCategoria (@RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) throws CategoriaImplException {
		return categoriaService.update(categoriaDTO, id);
	}
	
	@DeleteMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarCategoria (@PathVariable Long id) throws CategoriaImplException {
		categoriaService.deleteById(id);
	}
}