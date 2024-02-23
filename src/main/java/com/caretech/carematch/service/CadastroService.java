package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.Procurador;
import com.caretech.carematch.model.Usuario;
import com.caretech.carematch.repository.CuidadorRepository;
import com.caretech.carematch.repository.ProcuradorRepository;
import com.caretech.carematch.repository.UsuarioRepository;

@Service
public class CadastroService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProcuradorRepository procuradorRepository;
	
	@Autowired 
	private CuidadorRepository cuidadorRepository;
	
	public Usuario criarCadastro(Usuario usuario) throws Exception {
		try {
			//Validações
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
				
				if(StringUtils.isBlank(usuario.getPassword())) {
					throw new Exception("Informe a senha!");
				}
				
				if(StringUtils.isBlank(usuario.getTipoUsuario().getTipoUsuario())) {
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
				
				return usuarioRepository.save(usuario);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public Procurador concluirCadastroProcurador(Procurador procurador) throws Exception {
		try {
			
			if(procurador != null) {
				//Validações
				if(procurador.getUsuario() == null || procurador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necessário realizar o cadastro de usuário!");
				}
				
				if(StringUtils.isBlank(procurador.getDescricao())) {
					throw new Exception("Informe a Descrição!");
				}
				
				if(StringUtils.isNotBlank(procurador.getResumoNecessidade())) {
					throw new Exception("Informe o Resumo da Necessidade!");
				}
				
				return procuradorRepository.save(procurador);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public Cuidador concluirCadastroCuidador(Cuidador cuidador) throws Exception {
		try {
			
			if(cuidador != null) {
				//Validações
				
				if(cuidador.getUsuario() == null || cuidador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necessário realizar o cadastro de usuário!");
				}
				
				if(StringUtils.isBlank(cuidador.getDescricao())) {
					throw new Exception("Informe a Descrição!");
				}
				
				if(cuidador.getTempoExp() == 0) {
					throw new Exception("Informe o Tempo de Experiência!");
				}
				
				if(StringUtils.isBlank(cuidador.getUnidadeTempo())) {
					throw new Exception("Informe a Unidade de Tempo!");
				}
				
				if(StringUtils.isBlank(cuidador.getFormacao())) {
					throw new Exception("Informe a Formação!");
				}
				
				return cuidadorRepository.save(cuidador);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
}
