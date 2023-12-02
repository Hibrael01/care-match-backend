package com.caretech.carematch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Cidade;
import com.caretech.carematch.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository repository;
	
	@GetMapping
	public List<Cidade> listarCidades(){
		return repository.findAll();
	}
	
	@PostMapping
	public void gravarCidade(@RequestBody Cidade cidade) {
		repository.save(cidade);
	}
	
	@PutMapping
	public void alterarCidade(@RequestBody Cidade cidade) {
		if(cidade.getIdCidade() > 0) {
			repository.save(cidade);
		}
	}
	
	@DeleteMapping
	public void excluirCidade(@RequestBody Cidade cidade) {
		repository.delete(cidade);
	}
	
}
