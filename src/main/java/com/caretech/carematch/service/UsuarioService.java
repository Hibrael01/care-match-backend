package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Usuario;
import com.caretech.carematch.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario gravarUsuario(Usuario usuario) throws Exception {
		try {
			
			if(usuario != null) {
				
				if(StringUtils.isBlank(usuario.getNome())) {
					throw new Exception("Informe o nome!");
				}
				
				if(StringUtils.isBlank(usuario.getSobrenome())) {
					throw new Exception("Informe o sobrenome!");
				}
				
				if(StringUtils.isBlank(usuario.getLogin())) {
					throw new Exception("Informe o Login!");
				}
				
				if(StringUtils.isBlank(usuario.getSenha())) {
					throw new Exception("Informe a senha!");
				}
				
				if(StringUtils.isBlank(usuario.getTipoUsuario())) {
					throw new Exception("Informe o tipo de usuário!");
				}
				
				if(StringUtils.isBlank(usuario.getEmail())) {
					throw new Exception("Informe o Email!");
				}
				
				if(StringUtils.isBlank(usuario.getTelefone())) {
					throw new Exception("Informe o telefone!");
				}
				
				if(usuario.getDtNascimento() == null) {
					throw new Exception("Informe a Data de Nascimento!");
				}
				
				return repository.save(usuario);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public Usuario atualizarUsuario(Usuario usuario) throws Exception {
		try {
			
			if(usuario != null) {
				
				if(usuario.getIdUsuario() == 0) {
					throw new Exception("O usuário não existe no banco de dados ou seu código não foi informado!");
				}
				
				if(StringUtils.isBlank(usuario.getNome())) {
					throw new Exception("Informe o nome!");
				}
				
				if(StringUtils.isBlank(usuario.getSobrenome())) {
					throw new Exception("Informe o sobrenome!");
				}
				
				if(StringUtils.isBlank(usuario.getLogin())) {
					throw new Exception("Informe o Login!");
				}
				
				if(StringUtils.isBlank(usuario.getSenha())) {
					throw new Exception("Informe a senha!");
				}
				
				if(StringUtils.isBlank(usuario.getTipoUsuario())) {
					throw new Exception("Informe o tipo de usuário!");
				}
				
				if(StringUtils.isBlank(usuario.getEmail())) {
					throw new Exception("Informe o Email!");
				}
				
				if(StringUtils.isBlank(usuario.getTelefone())) {
					throw new Exception("Informe o telefone!");
				}
				
				if(usuario.getDtNascimento() == null) {
					throw new Exception("Informe a Data de Nascimento!");
				}
				
				return repository.save(usuario);
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
