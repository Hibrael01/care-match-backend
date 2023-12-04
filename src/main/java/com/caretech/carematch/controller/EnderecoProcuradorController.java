package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.EnderecoProcurador;
import com.caretech.carematch.service.EnderecoService;

@RestController
@RequestMapping("/enderecoProcurador")
public class EnderecoProcuradorController {
	
	@Autowired
	private EnderecoService service;
	
	@PostMapping
	public ResponseEntity<Object> criarEnderecoProcurador(@RequestBody EnderecoProcurador enderecoProcurador) {
	try {
		
		EnderecoProcurador retornoEnderecoProcurador = service.criarEnderecoProcurador(enderecoProcurador);
		
		if(retornoEnderecoProcurador != null && retornoEnderecoProcurador.getId() != null && retornoEnderecoProcurador.getId().getIdEndereco() != 0) {
			return ResponseEntity.ok(retornoEnderecoProcurador);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarEnderecoProcurador(@RequestBody EnderecoProcurador enderecoProcurador) {
	try {
		
		EnderecoProcurador retornoEnderecoProcurador = service.alterarEnderecoProcurador(enderecoProcurador);
		
		if(retornoEnderecoProcurador != null && retornoEnderecoProcurador.getId() != null && retornoEnderecoProcurador.getId().getIdEndereco() != 0) {
			return ResponseEntity.ok(retornoEnderecoProcurador);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}

}
