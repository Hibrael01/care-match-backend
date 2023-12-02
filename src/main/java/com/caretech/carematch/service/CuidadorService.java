package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.repository.CuidadorRepository;

@Service
public class CuidadorService {

	@Autowired
	private CuidadorRepository repository;
	
	public Cuidador gravarCuidador(Cuidador cuidador) throws Exception {
		try {
			
			if(cuidador != null) {
				
				if(cuidador.getUsuario() == null || cuidador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necesário informar um usuário cadastrado!");
				}
				
				if(cuidador.getTempoExp() == 0) {
					throw new Exception("Informe o tempo de experiência!");
				}
				
				if(StringUtils.isBlank(cuidador.getUnidadeTempo())) {
					throw new Exception("Informe a unidade de tempo para o tempo de experiência!");
				}
				
				if(StringUtils.isBlank(cuidador.getFormacao())) {
					throw new Exception("Informe a sua Formação!");
				}
				
				return repository.save(cuidador);
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Cuidador atualizarCuidador(Cuidador cuidador) throws Exception {
		try {
			
			if(cuidador != null) {
				
				if(cuidador.getIdCuidador() == 0) {
					throw new Exception("O cuidador informado não existe ou está sem código identificador!");		
				}
				
				if(cuidador.getUsuario() == null || cuidador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necesário informar um usuário cadastrado!");
				}
				
				if(cuidador.getTempoExp() == 0) {
					throw new Exception("Informe o tempo de experiência!");
				}
				
				if(StringUtils.isBlank(cuidador.getUnidadeTempo())) {
					throw new Exception("Informe a unidade de tempo para o tempo de experiência!");
				}
				
				if(StringUtils.isBlank(cuidador.getFormacao())) {
					throw new Exception("Informe a sua Formação!");
				}
				
				return repository.save(cuidador);
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
