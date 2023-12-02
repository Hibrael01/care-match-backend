package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.service.CuidadorService;

@RestController
@RequestMapping("/cuidador")
public class CuidadorController {
	
	@Autowired
	private CuidadorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarCuidador(@RequestBody Cuidador cuidador) {
		try {
			Cuidador retornoCuidador = service.gravarCuidador(cuidador);
			
			if(retornoCuidador != null  &&  retornoCuidador.getIdCuidador() != 0) {
				return ResponseEntity.ok(retornoCuidador);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarCuidador(@RequestBody Cuidador cuidador) {
		try {
			Cuidador retornoCuidador = service.atualizarCuidador(cuidador);
			
			if(retornoCuidador != null  &&  retornoCuidador.getIdCuidador() != 0) {
				return ResponseEntity.ok(retornoCuidador);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}

}
