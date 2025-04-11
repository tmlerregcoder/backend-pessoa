package com.exemple.backend_pessoa.model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String sexo;
    private String cpf;
    private Double altura;
    private Double peso;
    private String dataNascimento;
    
	public Pessoa(UUID id, String nome, String sexo, String cpf, Double altura, Double peso, String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
		this.dataNascimento = dataNascimento;
	}
    

}
