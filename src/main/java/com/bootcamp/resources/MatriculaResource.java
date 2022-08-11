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

import com.bootcamp.entities.Matricula;
import com.bootcamp.services.MatriculaService;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/matricula")
public class MatriculaResource {

	@Autowired
	private MatriculaService matriculaService;



	// ----------------------------------------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<Matricula> findById(@PathVariable Long id) {
		Matricula matricula = matriculaService.findById(id);

		return ResponseEntity.ok().body(matricula);
	}

	// ----------------------------------------------------------------------------
	@GetMapping
	public ResponseEntity<List<Matricula>> findAll() {

		List<Matricula> listaMatricula = matriculaService.findAll();

		return ResponseEntity.ok().body(listaMatricula);
	}

	// ----------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Matricula> insert(@RequestBody Matricula obj) {
		obj = matriculaService.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	// ----------------------------------------------------------------------------
	@PutMapping(value = "/{id}")
	public ResponseEntity<Matricula> update(@PathVariable Long id, @RequestBody Matricula obj) {

		obj = matriculaService.update(id, obj);

		return ResponseEntity.ok().body(obj);
	}

//----------------------------------------------------------------------------
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			matriculaService.delete(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
		

		return ResponseEntity.noContent().build();

	}
	
}
