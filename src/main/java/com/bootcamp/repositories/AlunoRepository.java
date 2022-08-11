package com.bootcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
