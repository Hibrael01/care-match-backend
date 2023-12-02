package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class ProcuradorXNecessidadeKey implements Serializable{
	private static final long serialVersionUID = 1068784401746664751L;

	@Column(name = "ID_NECESSIDADE")
	private Integer idNecessidade;
	
	@Column(name = "DIA_NECESSIDADE")
	private String diaNecessidade;
	
	@Column(name = "ID_PROCURADOR")
	private Integer procurador;
	
	public ProcuradorXNecessidadeKey() {
		super();
	}

	public ProcuradorXNecessidadeKey(Integer idNecessidade, String diaNecessidade, Integer procurador) {
		super();
		this.idNecessidade = idNecessidade;
		this.diaNecessidade = diaNecessidade;
		this.procurador = procurador;
	}

	public Integer getIdNecessidade() {
		return idNecessidade;
	}

	public void setIdNecessidade(Integer idNecessidade) {
		this.idNecessidade = idNecessidade;
	}

	public String getDiaNecessidade() {
		return diaNecessidade;
	}

	public void setDiaNecessidade(String diaNecessidade) {
		this.diaNecessidade = diaNecessidade;
	}

	public Integer getProcurador() {
		return procurador;
	}

	public void setProcurador(Integer procurador) {
		this.procurador = procurador;
	}

	@Override
	public String toString() {
		return "ProcuradorXNecessidadeKey [idNecessidade=" + idNecessidade + ", diaNecessidade=" + diaNecessidade
				+ ", procurador=" + procurador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaNecessidade, idNecessidade, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcuradorXNecessidadeKey other = (ProcuradorXNecessidadeKey) obj;
		return Objects.equals(diaNecessidade, other.diaNecessidade)
				&& Objects.equals(idNecessidade, other.idNecessidade) && Objects.equals(procurador, other.procurador);
	}

	
	
	
}
