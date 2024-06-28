package com.caretech.carematch.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.key.EnderecoCuidadorKey;
import com.caretech.carematch.model.Cuidador;
import com.caretech.carematch.model.CuidadorXCertificado;
import com.caretech.carematch.model.CuidadorXDisponibilidade;
import com.caretech.carematch.model.CuidadorXExperiencia;
import com.caretech.carematch.model.EnderecoCuidador;
import com.caretech.carematch.repository.CuidadorRepository;
import com.caretech.carematch.repository.CuidadorXCertificadoRepository;
import com.caretech.carematch.repository.CuidadorXDisponibilidadeRepository;
import com.caretech.carematch.repository.CuidadorXExperienciaRepository;
import com.caretech.carematch.repository.EnderecoCuidadorRepository;

@Service
public class CuidadorService {

	@Autowired
	private CuidadorRepository repository;
	
	@Autowired
	private EnderecoCuidadorRepository enderecoCuidadorRepository;
	
	@Autowired
	private CuidadorXCertificadoRepository cuidadorXCertificadoRepository;
	
	@Autowired
	private CuidadorXDisponibilidadeRepository cuidadorXDisponibilidadeRepository;
	
	@Autowired
	private CuidadorXExperienciaRepository cuidadorXExperienciaRepository;
	
	public Cuidador finalizarCadastroCuidador(Cuidador cuidador) throws Exception {
		try {
			
			//Primeiro Grava os dados referentes à entidade principal Cuidador
			if(cuidador != null) {
				if(StringUtils.isNotBlank(cuidador.getAtendeCasa()) && StringUtils.isNotBlank(cuidador.getDescricao()) && StringUtils.isNotBlank(cuidador.getFormacao())
						&& StringUtils.isNotBlank(cuidador.getUnidadeTempo()) && cuidador.getTempoExp() > 0) {
					
					Cuidador retorno =  repository.save(cuidador);
					
					if(retorno != null && retorno.getIdCuidador() != 0) {
						cuidador.setIdCuidador(retorno.getIdCuidador());
					}
					
					//Gravando dados relacionados com o cuidador: Endereço, disponibilidade, experiência e certificados
					
					//Gravando endereço
					if(cuidador.getEnderecoCuidador() != null) {
						cuidador.setIdCuidador(retorno.getIdCuidador());
						cuidador.getEnderecoCuidador().setIdCuidador(retorno.getIdCuidador());;
						EnderecoCuidador enderecoCuidador = cuidador.getEnderecoCuidador();
						
						
						enderecoCuidador = enderecoCuidadorRepository.save(enderecoCuidador);
						
						if(enderecoCuidador.getIdEndereco() != 0 && enderecoCuidador.getIdCuidador() != 0) {
							enderecoCuidador.setCuidador(null);
							cuidador.setEnderecoCuidador(enderecoCuidador);
						}
						
					}
					
					//Gravando Disponibilidade
					if(cuidador.getLstDisponibilidade() != null) {
						
						List<CuidadorXDisponibilidade> lstDisponibilidades = new ArrayList<CuidadorXDisponibilidade>();
						for(CuidadorXDisponibilidade disponibilidade : cuidador.getLstDisponibilidade()) {
							
							disponibilidade.setIdCuidador(retorno.getIdCuidador());
							
							disponibilidade = cuidadorXDisponibilidadeRepository.save(disponibilidade);
							
							if(disponibilidade.getIdDisponibilidade() != 0) {
								disponibilidade.setCuidador(null);
								lstDisponibilidades.add(disponibilidade);
							}
						}
						
						if(!lstDisponibilidades.isEmpty()) {
							cuidador.setLstDisponibilidade(lstDisponibilidades);
						}
						
					}
					
					//Gravando Experiência
					if(cuidador.getLstExperiencia() != null) {
						
						List<CuidadorXExperiencia> lstExperiencias = new ArrayList<CuidadorXExperiencia>();
						for(CuidadorXExperiencia experiencia : cuidador.getLstExperiencia()) {
					
							experiencia.setIdCuidador(retorno.getIdCuidador());
							
							experiencia = cuidadorXExperienciaRepository.save(experiencia);
							
							if(experiencia.getIdExperiencia() != 0 && experiencia.getIdCuidador() != 0) {
								experiencia.setCuidador(null);
								lstExperiencias.add(experiencia);
							}
						}
						
						if(!lstExperiencias.isEmpty()) {
							cuidador.setLstExperiencia(lstExperiencias);
						}
					}
					
					//Gravando Certificados
					if(cuidador.getLstCertificados() != null) {
						
						List<CuidadorXCertificado> lstCertificados = new ArrayList<CuidadorXCertificado>();
						for(CuidadorXCertificado certificado : cuidador.getLstCertificados()) {
							
							certificado.setIdCuidador(retorno.getIdCuidador());
							
							certificado = cuidadorXCertificadoRepository.save(certificado);
							
							if(certificado.getIdCertificado() != 0 && certificado.getIdCuidador() != 0) {
								certificado.setCuidador(null);
								lstCertificados.add(certificado);
							}
						}
						
						if(!lstCertificados.isEmpty()) {
							cuidador.setLstCertificados(lstCertificados);
						}
						
					}
					
				}else {
					throw new Exception("Informações referentes ao Cuidador invalidas, verifique-as e tente novamente!");
				}
			}
			
			return cuidador;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
