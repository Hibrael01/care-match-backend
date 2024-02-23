package com.caretech.carematch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.model.Usuario;
import com.caretech.carematch.repository.UsuarioRepository;
import com.caretech.carematch.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<Object> criarUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario retornoUsuario = service.gravarUsuario(usuario);
			
			if(retornoUsuario != null && retornoUsuario.getIdUsuario() != 0) {
				return ResponseEntity.ok(retornoUsuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@PutMapping
	public ResponseEntity<Object> alterarUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario retornoUsuario = service.atualizarUsuario(usuario);
			
			if(retornoUsuario != null && retornoUsuario.getIdUsuario() != 0) {
				return ResponseEntity.ok(retornoUsuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, verifique os parâmetros e o body enviado.");
	}
	
	@GetMapping
	public ResponseEntity<Object> consultarUsuarios() {
		try {
			
			List<Usuario> lstUsuarios = service.consultarUsuarios();
			
			if(lstUsuarios != null) {
				return ResponseEntity.ok(lstUsuarios);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro na requisição, vertifique os parâmetros!");
	}
	
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
