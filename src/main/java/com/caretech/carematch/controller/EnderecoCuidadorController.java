package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.EnderecoCuidador;
import com.caretech.carematch.service.EnderecoService;

@RestController
@RequestMapping("/enderecoCuidador")
public class EnderecoCuidadorController {

	@Autowired
	private EnderecoService service;
	
	@PostMapping
	public ResponseEntity<Object> criarEnderecoCuidador(@RequestBody EnderecoCuidador enderecoCuidador) {
	try {
		
		EnderecoCuidador retornoEnderecoCuidador = service.criarEnderecoCuidador(enderecoCuidador);
		
		if(retornoEnderecoCuidador != null && retornoEnderecoCuidador.getId() != null && retornoEnderecoCuidador.getId().getIdEndereco() != 0) {
			return ResponseEntity.ok(retornoEnderecoCuidador);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarEnderecoCuidador(@RequestBody EnderecoCuidador enderecoCuidador) {
	try {
		
		EnderecoCuidador retornoEnderecoCuidador = service.alterarEnderecoCuidador(enderecoCuidador);
		
		if(retornoEnderecoCuidador != null && retornoEnderecoCuidador.getId() != null && retornoEnderecoCuidador.getId().getIdEndereco() != 0) {
			return ResponseEntity.ok(retornoEnderecoCuidador);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
}
