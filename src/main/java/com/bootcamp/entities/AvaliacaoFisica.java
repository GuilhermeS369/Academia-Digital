package com.bootcamp.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AvaliacaoFisica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private LocalDateTime dataDaAvaliacao;
	private Double peso;
	private Double altura;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	@JsonIgnore
	private Aluno aluno;
	
	public AvaliacaoFisica() {
		
	}
	
	public AvaliacaoFisica(Long id, Aluno aluno, LocalDateTime dataDaAvaliacao, Double peso, Double altura) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.dataDaAvaliacao = dataDaAvaliacao;
		this.peso = peso;
		this.altura = altura;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}
	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
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
		AvaliacaoFisica other = (AvaliacaoFisica) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}