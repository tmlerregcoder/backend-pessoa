package com.exemple.backend_pessoa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.backend_pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
