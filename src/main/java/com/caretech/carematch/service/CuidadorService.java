package com.caretech.carematch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.CuidadorXCertificado;
import com.caretech.carematch.model.CuidadorXDisponibilidade;
import com.caretech.carematch.model.CuidadorXExperiencia;
import com.caretech.carematch.repository.CuidadorRepository;
import com.caretech.carematch.repository.CuidadorXCertificadoRepository;
import com.caretech.carematch.repository.CuidadorXDisponibilidadeRepository;
import com.caretech.carematch.repository.CuidadorXExperienciaRepository;

@Service
public class CuidadorService {

	@Autowired
	private CuidadorRepository repository;
	
	@Autowired
	private CuidadorXCertificadoRepository cuidadorXCertificadoRepository;
	
	@Autowired
	private CuidadorXDisponibilidadeRepository cuidadorXDisponibilidadeRepository;
	
	@Autowired
	private CuidadorXExperienciaRepository cuidadorXExperienciaRepository;
	
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
	
	public CuidadorXCertificado adicionarNovoCertificado(CuidadorXCertificado cuidadorXCertificado) throws Exception {
		try {
			
			if(cuidadorXCertificado != null) {
				
				return cuidadorXCertificadoRepository.save(cuidadorXCertificado);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public boolean excluirCertificado(CuidadorXCertificado cuidadorXCertificado) throws Exception {
		try {
			
			if(cuidadorXCertificado != null) {
				if(cuidadorXCertificado.getId() == null || cuidadorXCertificado.getId().getCuidador() == 0 || cuidadorXCertificado.getId().getIdCertificado() == 0) {
					throw new Exception("O identificador informado é inválido!");
				}
				
				cuidadorXCertificadoRepository.delete(cuidadorXCertificado);
				
				return true;
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	public CuidadorXDisponibilidade adicionarDisponibilidade(CuidadorXDisponibilidade cuidadorXDisponibilidade) throws Exception {
		try {
			
			if(cuidadorXDisponibilidade != null) {
				
				return cuidadorXDisponibilidadeRepository.save(cuidadorXDisponibilidade);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public CuidadorXDisponibilidade alterarDisponibilidade(CuidadorXDisponibilidade cuidadorXDisponibilidade) throws Exception {
		try {
			
			if(cuidadorXDisponibilidade != null) {
				
				if(cuidadorXDisponibilidade.getId() == null || cuidadorXDisponibilidade.getId().getCuidador() == 0 || cuidadorXDisponibilidade.getId().getIdDisponibilidade() == 0
						|| StringUtils.isBlank(cuidadorXDisponibilidade.getId().getDiaSemana())) {
					throw new Exception("O identificador informado é inválido!");
				}
				
				return cuidadorXDisponibilidadeRepository.save(cuidadorXDisponibilidade);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public CuidadorXExperiencia adicionarExperiencia(CuidadorXExperiencia cuidadorXExperiencia) throws Exception {
		try {
			
			if(cuidadorXExperiencia != null) {
				
				return cuidadorXExperienciaRepository.save(cuidadorXExperiencia);
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public boolean excluirExperiencia(CuidadorXExperiencia cuidadorXExperiencia) throws Exception {
		try {
			
			if(cuidadorXExperiencia != null) {
				
				if(cuidadorXExperiencia.getId() == null || cuidadorXExperiencia.getId().getCuidador() == 0 || cuidadorXExperiencia.getId().getIdExperiencia() == 0) {
					throw new Exception("O identificador informado é inválido!");
				}
				
				cuidadorXExperienciaRepository.delete(cuidadorXExperiencia);
				
				return true;
				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
}
