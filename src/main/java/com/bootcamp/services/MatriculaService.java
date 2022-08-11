package com.bootcamp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bootcamp.entities.Matricula;
import com.bootcamp.repositories.MatriculaRepository;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

@Service
public class MatriculaService {
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	//----------------------------------------------------------------------------
	public Matricula findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<Matricula> obj = matriculaRepository.findById(id);
		//RETORNA O OBJ
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	//----------------------------------------------------------------------------
	public List<Matricula> findAll(){
		return matriculaRepository.findAll();
	}
	
	
	//----------------------------------------------------------------------------
	public Matricula insert(Matricula matricula){
		
		return matriculaRepository.save(matricula);
		
		
	}
	
	
	//----------------------------------------------------------------------------
	public void delete(Long id) {
		try {
			matriculaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
	}
	
	
	//----------------------------------------------------------------------------
	public Matricula update (Long id, Matricula obj) {
		try {
			
			Matricula entity = matriculaRepository.getReferenceById(id);
			
			updateData(entity, obj);
			
			return matriculaRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	
	}

	private void updateData(Matricula entity, Matricula obj) {
		entity.setDataDaMatricula(obj.getDataDaMatricula());
	}
	//----------------------------------------------------------------------------
	
	
	
	
	
}
