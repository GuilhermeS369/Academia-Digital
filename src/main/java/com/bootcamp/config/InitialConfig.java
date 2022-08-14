package com.bootcamp.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bootcamp.entities.Aluno;
import com.bootcamp.entities.AvaliacaoFisica;
import com.bootcamp.entities.Matricula;
import com.bootcamp.repositories.AlunoRepository;
import com.bootcamp.repositories.AvaliacaoFisicaRepository;
import com.bootcamp.repositories.MatriculaRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class InitialConfig implements CommandLineRunner {
	@Autowired
	private AlunoRepository alunoRepo;
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoRepo;
	@Autowired
	private MatriculaRepository matRepo;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bootcamp.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
				
	}
	
	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title("API ESCOLA")
				.description("Api do projeto da Escola com um controle de alunos e suas matriculas")
				.version("0.1")
				.contact(new Contact("Guilherme",
						"https://github.com/GuilhermeS369",
						"Whatsapp: 11 963495981"))
				.build();
				
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
//		
//		Aluno aluno1 = new Aluno(null, "Guilherme", "123.456.789-99","Vila Noegueira", LocalDate.of(1999, 6, 22));
//		Aluno aluno2 = new Aluno(null, "Gustavo", "987.456.789-99","Vila Noemi", LocalDate.of(2007, 5, 31));
//		
//		Matricula mat1 = new Matricula(null, aluno1, LocalDateTime.of(2018, 07, 22, 10, 15, 30));
		
//		AvaliacaoFisica avaliacao1 = new AvaliacaoFisica(null, aluno1 , LocalDateTime.of(2022, 5, 13, 11, 23),	100.0,	1.80);
//		AvaliacaoFisica avaliacao2 = new AvaliacaoFisica(null, aluno1 , LocalDateTime.of(2022, 2, 25, 12, 00),	95.0,	1.82);
//		AvaliacaoFisica avaliacao3 = new AvaliacaoFisica(null, aluno2 , LocalDateTime.of(2022, 6, 8, 14, 00),	70.0,	1.60);
//		AvaliacaoFisica avaliacao4 = new AvaliacaoFisica(null, aluno2 , LocalDateTime.of(2022, 4, 11, 15, 50),	75.0,	1.70);
//				
//		alunoRepo.saveAll(Arrays.asList(aluno1,aluno2));
//		matRepo.save(mat1);
//		avaliacaoRepo.saveAll(Arrays.asList(avaliacao1, avaliacao2, avaliacao3, avaliacao4));
//		
//				
//		aluno1.getAvaliacoesFisica().addAll(Arrays.asList(avaliacao1, avaliacao2));
//		aluno2.getAvaliacoesFisica().addAll(Arrays.asList(avaliacao3, avaliacao4));
		
//		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2));
		
	
		
	}
	
	
}
