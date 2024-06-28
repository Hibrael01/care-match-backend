package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.EnderecoCuidador;
import com.caretech.carematch.model.EnderecoProcurador;
import com.caretech.carematch.repository.EnderecoCuidadorRepository;
import com.caretech.carematch.repository.EnderecoProcuradorRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoCuidadorRepository cuidadorRepository;
	 
	@Autowired
	private EnderecoProcuradorRepository procuradorRepository;
	
	public EnderecoCuidador criarEnderecoCuidador(EnderecoCuidador enderecoCuidador) throws Exception {
		try {
			
			if(enderecoCuidador != null) {
				if(StringUtils.isBlank(enderecoCuidador.getBairro())) {
					throw new Exception("Informe o Bairro!");
				}
				
				if(StringUtils.isBlank(enderecoCuidador.getCep())) {
					throw new Exception("Informe o CEP!");
				}
				
				if(StringUtils.isBlank(enderecoCuidador.getLogradouro())) {
					throw new Exception("Informe o Logradouro!");
				}
				
				if(enderecoCuidador.getCidade() == null || enderecoCuidador.getCidade().getIdCidade() == 0) {
					throw new Exception("Informe a Cidade do endereço!");
				}
				
				return cuidadorRepository.save(enderecoCuidador);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public EnderecoCuidador alterarEnderecoCuidador(EnderecoCuidador enderecoCuidador) throws Exception {
		try {
			
			if(enderecoCuidador != null) {
				
				if(enderecoCuidador.getIdCuidador() == 0 || enderecoCuidador.getIdEndereco() == 0) {
					throw new Exception("O ID informado está inválido!");
				}
				
				if(StringUtils.isBlank(enderecoCuidador.getBairro())) {
					throw new Exception("Informe o Bairro!");
				}
				
				if(StringUtils.isBlank(enderecoCuidador.getCep())) {
					throw new Exception("Informe o CEP!");
				}
				
				if(StringUtils.isBlank(enderecoCuidador.getLogradouro())) {
					throw new Exception("Informe o Logradouro!");
				}
				
				if(enderecoCuidador.getCidade() == null || enderecoCuidador.getCidade().getIdCidade() == 0) {
					throw new Exception("Informe a Cidade do endereço!");
				}
				
				return cuidadorRepository.save(enderecoCuidador);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public EnderecoProcurador criarEnderecoProcurador(EnderecoProcurador enderecoProcurador) throws Exception {
		try {
			
			if(enderecoProcurador != null) {
				if(StringUtils.isBlank(enderecoProcurador.getBairro())) {
					throw new Exception("Informe o Bairro!");
				}
				
				if(StringUtils.isBlank(enderecoProcurador.getCep())) {
					throw new Exception("Informe o CEP!");
				}
				
				if(StringUtils.isBlank(enderecoProcurador.getLogradouro())) {
					throw new Exception("Informe o Logradouro!");
				}
				
				if(enderecoProcurador.getCidade() == null || enderecoProcurador.getCidade().getIdCidade() == 0) {
					throw new Exception("Informe a Cidade do endereço!");
				}
				
				return procuradorRepository.save(enderecoProcurador);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public EnderecoProcurador alterarEnderecoProcurador(EnderecoProcurador enderecoProcurador) throws Exception {
		try {
			
			if(enderecoProcurador != null) {
				
				if(enderecoProcurador.getId() == null || enderecoProcurador.getId().getIdEndereco() == 0 || enderecoProcurador.getId().getProcurador() == 0) {
					throw new Exception("O ID informado está inválido!");
				}
				
				if(StringUtils.isBlank(enderecoProcurador.getBairro())) {
					throw new Exception("Informe o Bairro!");
				}
				
				if(StringUtils.isBlank(enderecoProcurador.getCep())) {
					throw new Exception("Informe o CEP!");
				}
				
				if(StringUtils.isBlank(enderecoProcurador.getLogradouro())) {
					throw new Exception("Informe o Logradouro!");
				}
				
				if(enderecoProcurador.getCidade() == null || enderecoProcurador.getCidade().getIdCidade() == 0) {
					throw new Exception("Informe a Cidade do endereço!");
				}
				
				return procuradorRepository.save(enderecoProcurador);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
