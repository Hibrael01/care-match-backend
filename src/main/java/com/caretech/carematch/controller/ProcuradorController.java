package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.Procurador;
import com.caretech.carematch.service.ProcuradorService;

@RestController
@RequestMapping("/procurador")
public class ProcuradorController {
	
	@Autowired
	private ProcuradorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarProcurador(@RequestBody Procurador procurador) {
		try {
			Procurador retornoProcurador = service.gravarProcurador(procurador);
			
			if(retornoProcurador != null  &&  retornoProcurador.getIdProcurador() != 0) {
				return ResponseEntity.ok(retornoProcurador);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarProcurador(@RequestBody Procurador procurador) {
		try {
			Procurador retornoProcurador = service.atualizarProcurador(procurador);
			
			if(retornoProcurador != null  &&  retornoProcurador.getIdProcurador() != 0) {
				return ResponseEntity.ok(retornoProcurador);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	

}
