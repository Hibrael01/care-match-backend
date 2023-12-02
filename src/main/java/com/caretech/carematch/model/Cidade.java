package com.caretech.carematch.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CIDADE", schema = "CAREMATCH")
public class Cidade {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Integer idCidade;
	
	private Integer codCidade;
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 2)
	private String uf;
	
	@Column(length = 60)
	private String pais;

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Integer codCidade) {
		this.codCidade = codCidade;
	}

	public String getNome() {
		if(nome == null) {
			nome = "";
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		if(uf == null) {
			uf = "";
		}
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		if(pais == null) {
			pais = "";
		}
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCidade, idCidade, nome, pais, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(codCidade, other.codCidade) && Objects.equals(idCidade, other.idCidade)
				&& Objects.equals(nome, other.nome) && Objects.equals(pais, other.pais) && Objects.equals(uf, other.uf);
	}
	
	
}
