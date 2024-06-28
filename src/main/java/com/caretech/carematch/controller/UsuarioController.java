package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Usuario;
import com.caretech.carematch.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/login")
	public ResponseEntity<Object> getUsuarioByLogin(@RequestParam("userLogin") String login) {
		try {
			
			Usuario usuario = service.getUsuarioByLogin(login);
			
			if(usuario != null && usuario.getIdUsuario() != 0) {
				return ResponseEntity.ok().body(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, vertifique os parâmetros!");
	}
	
}
