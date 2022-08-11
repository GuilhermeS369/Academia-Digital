package com.bootcamp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcamp.entities.AvaliacaoFisica;
import com.bootcamp.services.AvaliacaoFisicaService;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoFisicaResource {
	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;



	// ----------------------------------------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisica> findById(@PathVariable Long id) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.findById(id);

		return ResponseEntity.ok().body(avaliacaoFisica);
	}

	// ----------------------------------------------------------------------------
	@GetMapping
	public ResponseEntity<List<AvaliacaoFisica>> findAll() {

		List<AvaliacaoFisica> listaAvaliacaoFisica = avaliacaoFisicaService.findAll();

		return ResponseEntity.ok().body(listaAvaliacaoFisica);
	}

	// ----------------------------------------------------------------------------
	@PostMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisica> insert(@PathVariable Long id, @RequestBody AvaliacaoFisica obj) {
		obj = avaliacaoFisicaService.insert(obj, id);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	// ----------------------------------------------------------------------------
	@PutMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisica obj) {

		obj = avaliacaoFisicaService.update(id, obj);

		return ResponseEntity.ok().body(obj);
	}

//----------------------------------------------------------------------------
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			avaliacaoFisicaService.delete(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
		

		return ResponseEntity.noContent().build();

	}
}
