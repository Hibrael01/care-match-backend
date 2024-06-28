package com.caretech.carematch.controller;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.converters.LocalDateAdapter;
import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.service.CuidadorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuidador")
public class CuidadorController {
	
	@Autowired
	private CuidadorService cuidadorService;
	
	@PostMapping("/finalizaCadastro")
	public ResponseEntity<Object> finalizarCadastroCuidador(@RequestBody Cuidador cuidador) {
		try {
			
			Cuidador cuidadorResponse = cuidadorService.finalizarCadastroCuidador(cuidador);
			
			if(cuidadorResponse != null) {
				
				Gson gson = new GsonBuilder()
						.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
						.create();
				String jsonCuidadorResponse = gson.toJson(cuidadorResponse);
				
				if(StringUtils.isNotBlank(jsonCuidadorResponse)) {
					return ResponseEntity.ok(jsonCuidadorResponse);
				}else {
					return ResponseEntity.badRequest().body("Não foi possível finalizar o cadastro, verifique os dados informados e tente novamente!");
				}
			}else {
				return ResponseEntity.badRequest().body("Não foi possível finalizar o cadastro, verifique os dados informados e tente novamente!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
