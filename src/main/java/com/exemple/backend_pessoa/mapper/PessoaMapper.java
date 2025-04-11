package com.exemple.backend_pessoa.mapper;

import com.exemple.backend_pessoa.dto.PessoaDTO;
import com.exemple.backend_pessoa.model.Pessoa;

public class PessoaMapper {

    public static PessoaDTO toDTO(Pessoa pessoa) {
        if (pessoa == null) {
            return null;
        }

        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setSexo(pessoa.getSexo());
        dto.setCpf(pessoa.getCpf());
        dto.setAltura(pessoa.getAltura());
        dto.setPeso(pessoa.getPeso());
        dto.setDataNascimento(pessoa.getDataNascimento());

        return dto;
    }
    
    public static Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());
        pessoa.setSexo(dto.getSexo());
        pessoa.setCpf(dto.getCpf());
        pessoa.setAltura(dto.getAltura());
        pessoa.setPeso(dto.getPeso());
        pessoa.setDataNascimento(dto.getDataNascimento());

        return pessoa;
    }   

}
