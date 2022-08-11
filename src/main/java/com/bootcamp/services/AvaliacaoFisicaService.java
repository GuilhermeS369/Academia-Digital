package com.bootcamp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bootcamp.entities.AvaliacaoFisica;
import com.bootcamp.repositories.AvaliacaoFisicaRepository;
import com.bootcamp.services.exceptions.DatabaseException;
import com.bootcamp.services.exceptions.ResourceNotFoundException;

@Service
public class AvaliacaoFisicaService {
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	//----------------------------------------------------------------------------
	public AvaliacaoFisica findById(Long id) {
		//TIPO OPTIONAL ARMAZENA O OBJ
		Optional<AvaliacaoFisica> obj = avaliacaoFisicaRepository.findById(id);
		//RETORNA O OBJ
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	//----------------------------------------------------------------------------
	public List<AvaliacaoFisica> findAll(){
		return avaliacaoFisicaRepository.findAll();
	}
	
	
	//----------------------------------------------------------------------------
	public AvaliacaoFisica insert(AvaliacaoFisica avaliacaoFisica){
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
		
	}
	
	
	//----------------------------------------------------------------------------
	public void delete(Long id) {
		try {
			avaliacaoFisicaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
			
		}
	}
	
	
	//----------------------------------------------------------------------------
	public AvaliacaoFisica update (Long id, AvaliacaoFisica obj) {
		try {
			
			AvaliacaoFisica entity = avaliacaoFisicaRepository.getReferenceById(id);
			
			updateData(entity, obj);
			
			return avaliacaoFisicaRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	
	}

	private void updateData(AvaliacaoFisica entity, AvaliacaoFisica obj) {
		entity.setAltura(obj.getAltura());
		entity.setPeso(obj.getPeso());
		entity.setDataDaAvaliacao(obj.getDataDaAvaliacao());
	
	}
	//----------------------------------------------------------------------------
	
	
	
	
	
}
