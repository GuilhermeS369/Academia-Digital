package com.bootcamp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private String bairro;
	private LocalDate dataDeNascimento;
	@OneToMany(mappedBy = "aluno")
		//private Set <OrderItem> items = new HashSet<>();
	private List<AvaliacaoFisica> avaliacoesFisica = new ArrayList<>();
	@OneToOne
	private Matricula matricula;
	
	public Aluno() {
		
	}
	public Aluno(Long id, String name, String cpf, String bairro, LocalDate dataDeNascimento) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public List<AvaliacaoFisica> getAvaliacoesFisica() {
		return avaliacoesFisica;
	}
	public void setAvaliacoesFisica(List<AvaliacaoFisica> avaliacoesFisica) {
		this.avaliacoesFisica = avaliacoesFisica;
	}
	
	
	
	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}
	

	
	
	
	
}
