package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.CuidadorXCertificado;
import com.caretech.carematch.model.CuidadorXExperiencia;
import com.caretech.carematch.service.CuidadorService;

@RestController
@RequestMapping("/cuidadorXExperiencia")
public class CuidadorXExperienciaController {

	@Autowired
	private CuidadorService service;
	
	@PostMapping
	public ResponseEntity<Object> criarCuidadorXExperiencia(@RequestBody CuidadorXExperiencia cuidadorXExperiencia) {
		try {
			CuidadorXExperiencia retornoCuidadorXExperiencia = service.adicionarExperiencia(cuidadorXExperiencia);
			
			if(retornoCuidadorXExperiencia != null  &&  retornoCuidadorXExperiencia.getId() != null && retornoCuidadorXExperiencia.getId().getCuidador() != 0
					&& retornoCuidadorXExperiencia.getId().getIdExperiencia() != 0) {
				return ResponseEntity.ok(retornoCuidadorXExperiencia);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@DeleteMapping
	public ResponseEntity<Object> excluirCuidadorXExperiencia(@RequestBody CuidadorXExperiencia cuidadorXExperiencia) {
		try {
			boolean retorno  = service.excluirExperiencia(cuidadorXExperiencia);
			
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
