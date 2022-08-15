package com.bootcamp.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tb_avaliacoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AvaliacaoFisica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private LocalDateTime dataDaAvaliacao;
	
	@Column(name = "peso_atual")
	private Double peso;
	
	@Column(name = "altura_atual")
	private Double altura;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	

	
	
	
	
	
}
