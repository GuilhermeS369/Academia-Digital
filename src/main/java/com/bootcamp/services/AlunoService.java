package com.bootcamp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entities.Aluno;
import com.bootcamp.repositories.AlunoRepository;
import com.bootcamp.services.exceptions.ResourceNotFoundException;
@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public Aluno findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Aluno> obj = alunoRepository.findById(id);
		//RETORNA O OBJ
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno insert(Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
}
