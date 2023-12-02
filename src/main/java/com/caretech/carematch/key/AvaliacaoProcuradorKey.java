package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class AvaliacaoProcuradorKey implements Serializable {
	private static final long serialVersionUID = -2942403889216004143L;

	@Column(name = "ID_AVALIACAO")
	private Integer idAvaliacao;
	
	@Column(name = "ID_PROCURADOR")
	private Integer procurador;

	public AvaliacaoProcuradorKey(Integer idAvaliacao, Integer procurador) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.procurador = procurador;
	}

	public AvaliacaoProcuradorKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Integer getProcurador() {
		return procurador;
	}

	public void setProcurador(Integer procurador) {
		this.procurador = procurador;
	}

	@Override
	public String toString() {
		return "AvaliacaoProcuradorKey [idAvaliacao=" + idAvaliacao + ", procurador=" + procurador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAvaliacao, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoProcuradorKey other = (AvaliacaoProcuradorKey) obj;
		return Objects.equals(idAvaliacao, other.idAvaliacao) && Objects.equals(procurador, other.procurador);
	}
	
	
	
}
