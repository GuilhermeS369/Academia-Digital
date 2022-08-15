package com.bootcamp.resources;

import java.net.URI;
import java.util.List;

import com.bootcamp.entities.AvaliacaoFisica;
import com.bootcamp.services.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcamp.entities.Aluno;
import com.bootcamp.entities.DTO.AlunoDTO;
import com.bootcamp.services.AlunoService;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;



	// ----------------------------------------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno aluno = alunoService.findById(id);

		return ResponseEntity.ok().body(aluno);
	}

	// ----------------------------------------------------------------------------
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(@RequestParam (value = ("dataDeNascimento"), required = false) String dataDeNascimento) {

		List<Aluno> listaAluno = alunoService.findAll(dataDeNascimento);

		return ResponseEntity.ok().body(listaAluno);
	}

	// ----------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Aluno> insert(@Valid @RequestBody AlunoDTO obj) {
		Aluno aluno = alunoService.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).body(aluno);
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

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
		return avaliacaoFisicaService.getAllAvaliacaoFisica(id);
	}


}