package com.exemple.backend_pessoa.dto;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaDTO {
	private UUID id;
	private String nome;
	private String sexo;
	private String cpf;
	private Double altura;
	private Double peso;
	private String dataNascimento;

	public PessoaDTO(UUID id, String nome, String sexo, String cpf, Double altura, Double peso, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
		this.dataNascimento = dataNascimento;
	}
}
