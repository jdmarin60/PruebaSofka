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
	
	@GetMapping("/premios")
	public List<CategoriaModel> listarPremios() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/premios/{id}")
	public CategoriaModel mostrarPremio(@PathVariable Long id) throws CategoriaImplException {
		return categoriaService.findById(id);
	}
	
	@PostMapping("/premios")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaModel crearPremio (@RequestBody CategoriaDTO categoriaDTO) {
		return categoriaService.create(categoriaDTO);
	}
	
	@PutMapping("/premios/{id}")
	public CategoriaModel updatePremio (@RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) throws CategoriaImplException {
		return categoriaService.update(categoriaDTO, id);
	}
	
	@DeleteMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPremio (@PathVariable Long id) throws CategoriaImplException {
		categoriaService.deleteById(id);
	}
}