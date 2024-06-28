package com.caretech.carematch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caretech.carematch.model.Cidade;
import com.caretech.carematch.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> listarCidades() throws Exception {
		try {
			
			List<Cidade> lstCidades = new ArrayList<Cidade>();
		
			lstCidades = repository.findAll();
			
			return lstCidades;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
