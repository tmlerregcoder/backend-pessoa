package com.exemple.backend_pessoa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exemple.backend_pessoa.dto.PessoaDTO;
import com.exemple.backend_pessoa.service.PessoaService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

	private final PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listarPessoas() {
		List<PessoaDTO> pessoas = pessoaService.listarPessoas();
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> buscarPessoa(@PathVariable UUID id) {        
		return Optional.ofNullable(pessoaService.buscarPessoa(id)).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> incluirPessoa(@RequestBody PessoaDTO pessoa) {
		PessoaDTO novaPessoa = pessoaService.incluirPessoa(pessoa);
		return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> alterarPessoa(@PathVariable UUID id, @RequestBody PessoaDTO pessoaAtualizada) {
		Optional<PessoaDTO> pessoaPersistida = Optional.ofNullable(pessoaService.alterarPessoa(id, pessoaAtualizada));
		if (pessoaPersistida.isPresent()) {            
			return new ResponseEntity<>(pessoaPersistida.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPessoa(@PathVariable UUID id) {
		if (pessoaService.excluirPessoa(id)){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/peso-ideal")
	public ResponseEntity<Double> calcularPesoIdeal(@RequestParam UUID id) {
		Optional<Double> pesoIdeal = Optional.ofNullable(pessoaService.calcularPesoIdeal(id));
		if (pesoIdeal.isPresent()) {         
			return new ResponseEntity<>(pesoIdeal.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
