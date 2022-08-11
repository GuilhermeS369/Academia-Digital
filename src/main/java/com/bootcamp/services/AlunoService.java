package com.bootcamp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bootcamp.entities.Aluno;
import com.bootcamp.repositories.AlunoRepository;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;
@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	//----------------------------------------------------------------------------
	public Aluno findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Aluno> obj = alunoRepository.findById(id);
		//RETORNA O OBJ
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	//----------------------------------------------------------------------------
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	
	//----------------------------------------------------------------------------
	public Aluno insert(Aluno aluno){
		return alunoRepository.save(aluno);
		
	}
	
	
	//----------------------------------------------------------------------------
	public void delete(Long id) {
		try {
			alunoRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
	}
	
	
	//----------------------------------------------------------------------------
	public Aluno update (Long id, Aluno obj) {
		try {
			
			Aluno entity = alunoRepository.getReferenceById(id);
			
			updateData(entity, obj);
			
			return alunoRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	
	}

	private void updateData(Aluno entity, Aluno obj) {
		entity.setName(obj.getName());
		entity.setBairro(obj.getBairro());
		entity.setCpf(obj.getCpf());
		entity.setDataDeNascimento(obj.getDataDeNascimento());
				
	}
	//----------------------------------------------------------------------------
	
	
	
	
	
	
}
