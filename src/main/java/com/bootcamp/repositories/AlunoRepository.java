package com.bootcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entities.Aluno;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

    List<Aluno> findByBairro(String bairro);






}
