package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.CuidadorXCertificado;
import com.caretech.carematch.service.CuidadorService;

@RestController
@RequestMapping("/cuidadorXCertificado")
public class CuidadorXCertificadoController {

	@Autowired
	private CuidadorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarCuidadorXCertificado(@RequestBody CuidadorXCertificado cuidadorXCertificado) {
		try {
			CuidadorXCertificado retornoCuidadorXCertificado = service.adicionarNovoCertificado(cuidadorXCertificado);
			
			if(retornoCuidadorXCertificado != null  &&  retornoCuidadorXCertificado.getId() != null && retornoCuidadorXCertificado.getId().getCuidador() != 0
					&& retornoCuidadorXCertificado.getId().getIdCertificado() != 0) {
				return ResponseEntity.ok(retornoCuidadorXCertificado);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@DeleteMapping
	public ResponseEntity<Object> excluirCuidadorXCertificado(@RequestBody CuidadorXCertificado cuidadorXCertificado) {
		try {
			boolean retorno  = service.excluirCertificado(cuidadorXCertificado);
			
			if(retorno) {
				return ResponseEntity.ok("Certificado excluído com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
}
