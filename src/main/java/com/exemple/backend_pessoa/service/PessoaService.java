package com.exemple.backend_pessoa.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.exemple.backend_pessoa.dto.PessoaDTO;
import com.exemple.backend_pessoa.mapper.PessoaMapper;
import com.exemple.backend_pessoa.model.Pessoa;
import com.exemple.backend_pessoa.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired(required = true)
    private PessoaRepository pessoaRepository;
    
    public PessoaDTO buscarPessoa(UUID id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(PessoaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));       
    }

    public List<PessoaDTO> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        if(pessoas.isEmpty()) {
            throw new RuntimeException("Nenhuma pessoa encontrada");
        } 
        return pessoas.stream()
                .map(PessoaMapper::toDTO)
                .toList();       
    }

    public PessoaDTO incluirPessoa(PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoa = Optional.ofNullable(pessoaRepository.save(PessoaMapper.toEntity(pessoaDTO)));
        return pessoa.map(PessoaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Não foi possivel salvar a pessoa"));       
    }

    public PessoaDTO alterarPessoa(UUID id, PessoaDTO pessoaAtualizada) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            pessoaAtualizada.setId(id);
            return PessoaMapper.toDTO(pessoaRepository.save(PessoaMapper.toEntity(pessoaAtualizada)));         
           
        }
        else {
            throw new RuntimeException("Pessoa não encontrada");            
        }
    }

    public boolean excluirPessoa(@PathVariable UUID id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;           
        }else {
            return false;          
        }
    }

    public Double calcularPesoIdeal(UUID id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            double altura = pessoa.getAltura();           
            String sexo = pessoa.getSexo();
            double pesoIdeal = 0.0;
            DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
            df.setRoundingMode(java.math.RoundingMode.HALF_UP);

            if (sexo.equalsIgnoreCase("M")) {
                pesoIdeal = (72.7 * altura) - 58;
            } else if (sexo.equalsIgnoreCase("F")) {
                pesoIdeal = (62.1 * altura) - 44.7;
            }
            return Double.parseDouble(df.format(pesoIdeal));
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }
}
