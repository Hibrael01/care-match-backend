package com.caretech.carematch.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.CuidadorXCertificado;
import com.caretech.carematch.model.CuidadorXDisponibilidade;
import com.caretech.carematch.service.CuidadorService;

@RestController
@RequestMapping("/cuidadorXDisponibilidade")
public class CuidadorXDisponibilidadeController {

	@Autowired
	private CuidadorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarCuidadorXDisponibilidade(@RequestBody CuidadorXDisponibilidade cuidadorXDisponibilidade) {
		try {
			CuidadorXDisponibilidade retornoCuidadorXDisponibilidade = service.adicionarDisponibilidade(cuidadorXDisponibilidade);
			
			if(retornoCuidadorXDisponibilidade != null  &&  retornoCuidadorXDisponibilidade.getId() != null && retornoCuidadorXDisponibilidade.getId().getCuidador() != 0
					&& retornoCuidadorXDisponibilidade.getId().getIdDisponibilidade() != 0 && StringUtils.isNotBlank(retornoCuidadorXDisponibilidade.getId().getDiaSemana())) {
				return ResponseEntity.ok(retornoCuidadorXDisponibilidade);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarCuidadorXDisponibilidade(@RequestBody CuidadorXDisponibilidade cuidadorXDisponibilidade) {
		try {
			CuidadorXDisponibilidade retornoCuidadorXDisponibilidade = service.alterarDisponibilidade(cuidadorXDisponibilidade);
			
			if(retornoCuidadorXDisponibilidade != null  &&  retornoCuidadorXDisponibilidade.getId() != null && retornoCuidadorXDisponibilidade.getId().getCuidador() != 0
					&& retornoCuidadorXDisponibilidade.getId().getIdDisponibilidade() != 0 && StringUtils.isNotBlank(retornoCuidadorXDisponibilidade.getId().getDiaSemana())) {
				return ResponseEntity.ok(retornoCuidadorXDisponibilidade);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
}
