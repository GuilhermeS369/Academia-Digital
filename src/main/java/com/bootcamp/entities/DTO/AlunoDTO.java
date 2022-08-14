package com.bootcamp.entities.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

	private String name;
	
	private String cpf;
	
	private String bairro;
	
	private LocalDate dataDeNascimento;


	
	
	
}
