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

import com.bootcamp.entities.Aluno;
import com.bootcamp.services.AlunoService;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {
	@Autowired
	private AlunoService alunoService;

	@Autowired

	// ----------------------------------------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno aluno = alunoService.findById(id);

		return ResponseEntity.ok().body(aluno);
	}

	// ----------------------------------------------------------------------------
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {

		List<Aluno> listaAluno = alunoService.findAll();

		return ResponseEntity.ok().body(listaAluno);
	}

	// ----------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
		obj = alunoService.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	// ----------------------------------------------------------------------------
	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno obj) {

		obj = alunoService.update(id, obj);

		return ResponseEntity.ok().body(obj);
	}

//----------------------------------------------------------------------------
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			alunoService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
		

		return ResponseEntity.noContent().build();

	}

}