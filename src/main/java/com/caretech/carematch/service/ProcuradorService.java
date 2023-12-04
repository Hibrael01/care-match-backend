package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.Procurador;
import com.caretech.carematch.model.ProcuradorXNecessidade;
import com.caretech.carematch.repository.ProcuradorRepository;
import com.caretech.carematch.repository.ProcuradorXNecessidadeRepository;

@Service
public class ProcuradorService {
	
	@Autowired
	private ProcuradorRepository repository;
	
	@Autowired
	private ProcuradorXNecessidadeRepository procuradorXNecessidadeRepository;
	
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
	
	public ProcuradorXNecessidade criarProcuradorXNecessidade(ProcuradorXNecessidade procuradorXNecessidade) throws Exception {
		try {
			
			if(procuradorXNecessidade != null) {
				return procuradorXNecessidadeRepository.save(procuradorXNecessidade);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public ProcuradorXNecessidade alterarProcuradorXNecessidade(ProcuradorXNecessidade procuradorXNecessidade) throws Exception {
		try {
			
			if(procuradorXNecessidade != null) {
				
				if(procuradorXNecessidade.getId() == null || procuradorXNecessidade.getId().getIdNecessidade() == 0 || procuradorXNecessidade.getId().getProcurador() == 0 
						|| StringUtils.isBlank(procuradorXNecessidade.getId().getDiaNecessidade())) {
					throw new Exception("O formato da chave identificadora informada é inválido!");
				}
				
				return procuradorXNecessidadeRepository.save(procuradorXNecessidade);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	
}
