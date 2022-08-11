package com.bootcamp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.entities.Aluno;
import com.bootcamp.services.AlunoService;
@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id){
		Aluno aluno = alunoService.findById(id);
		
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		
		List<Aluno> listaAluno = alunoService.findAll();
		
		return ResponseEntity.ok().body(listaAluno);
	}
	
}
