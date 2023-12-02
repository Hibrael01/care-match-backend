package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.Procurador;
import com.caretech.carematch.repository.ProcuradorRepository;

@Service
public class ProcuradorService {
	
	@Autowired
	private ProcuradorRepository repository;
	
	public Procurador gravarProcurador(Procurador procurador) throws Exception {
		try {
			
			if(procurador != null) {
				
				if(procurador.getUsuario() == null || procurador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necesário informar um usuário cadastrado!");
				}
				
				if(StringUtils.isBlank(procurador.getResumoNecessidade())) {
					throw new Exception("Informe o resumo de sua necessidade!");
				}
				
				return repository.save(procurador);
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Procurador atualizarProcurador(Procurador procurador) throws Exception {
		try {
			
			if(procurador != null) {
				
				if(procurador.getIdProcurador() == 0) {
					throw new Exception("O procurador informado não existe ou está sem código identificador!");
				}
				
				if(procurador.getUsuario() == null || procurador.getUsuario().getIdUsuario() == 0) {
					throw new Exception("É necesário informar um usuário cadastrado!");
				}
				
				if(StringUtils.isBlank(procurador.getResumoNecessidade())) {
					throw new Exception("Informe o resumo de sua necessidade!");
				}
				
				return repository.save(procurador);
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
