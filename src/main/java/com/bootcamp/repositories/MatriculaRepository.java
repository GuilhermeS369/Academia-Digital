package com.bootcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
