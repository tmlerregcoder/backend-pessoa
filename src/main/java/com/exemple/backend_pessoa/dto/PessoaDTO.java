package com.exemple.backend_pessoa.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class PessoaDTO {
    private UUID id;
    private String nome;
    private String sexo;
    private String cpf;
    private Double altura;
    private Double peso;
    private String dataNascimento;

}
