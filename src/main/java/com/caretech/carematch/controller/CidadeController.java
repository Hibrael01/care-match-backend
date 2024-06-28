package com.caretech.carematch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Cidade;
import com.caretech.carematch.service.CidadeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public ResponseEntity<Object> buscarCIdades() {
		try {
			
			List<Cidade> lstCidades = new ArrayList<Cidade>();
			
			lstCidades = service.listarCidades();
			
			return ResponseEntity.ok(lstCidades);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
