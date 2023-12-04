package com.caretech.carematch.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.EnderecoCuidador;
import com.caretech.carematch.model.ProcuradorXNecessidade;
import com.caretech.carematch.service.ProcuradorService;

@RestController
@RequestMapping("/procuradorXNecessidade")
public class ProcuradorXNecessidadeController {

	@Autowired
	private ProcuradorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarProcuradorXNecessidade(@RequestBody ProcuradorXNecessidade procuradorXNecessidade) {
	try {
		
		ProcuradorXNecessidade retornoProcuradorXNecessidade = service.criarProcuradorXNecessidade(procuradorXNecessidade);
		
		if(retornoProcuradorXNecessidade != null && retornoProcuradorXNecessidade.getId() != null && retornoProcuradorXNecessidade.getId().getProcurador() != 0
				&& retornoProcuradorXNecessidade.getId().getIdNecessidade() != 0 && StringUtils.isNotBlank(retornoProcuradorXNecessidade.getId().getDiaNecessidade())) {
			return ResponseEntity.ok(retornoProcuradorXNecessidade);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarProcuradorXNecessidade(@RequestBody ProcuradorXNecessidade procuradorXNecessidade) {
	try {
		
		ProcuradorXNecessidade retornoProcuradorXNecessidade = service.alterarProcuradorXNecessidade(procuradorXNecessidade);
		
		if(retornoProcuradorXNecessidade != null && retornoProcuradorXNecessidade.getId() != null && retornoProcuradorXNecessidade.getId().getProcurador() != 0
				&& retornoProcuradorXNecessidade.getId().getIdNecessidade() != 0 && StringUtils.isNotBlank(retornoProcuradorXNecessidade.getId().getDiaNecessidade())) {
			return ResponseEntity.ok(retornoProcuradorXNecessidade);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	
	
}
