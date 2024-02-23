package com.caretech.carematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caretech.carematch.configuration.TokenService;
import com.caretech.carematch.model.AuthenticationDTO;
import com.caretech.carematch.model.LoginResponseDTO;
import com.caretech.carematch.model.RegisterDTO;
import com.caretech.carematch.model.Usuario;
import com.caretech.carematch.repository.UsuarioRepository;
import com.caretech.carematch.service.UsuarioService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken( (Usuario) auth.getPrincipal());
		
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
		
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid Usuario data) {
		try {
			
			if(this.service.findByLogin(data.getLogin()) != null) {
				return ResponseEntity.badRequest().build();
			}
			
			String oldPassword = data.getPassword();
			String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
			
			data.setSenha(encryptedPassword);
			
			Usuario retornoUsuario = this.service.gravarUsuario(data);
			retornoUsuario.setSenha(oldPassword);
			
			return ResponseEntity.ok(retornoUsuario);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		} 
	}
	
}
