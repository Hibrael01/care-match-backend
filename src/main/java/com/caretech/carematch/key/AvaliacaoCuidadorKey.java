package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class AvaliacaoCuidadorKey implements Serializable {
	private static final long serialVersionUID = -529032908076705517L;

	@Column(name = "ID_AVALIACAO")
	private Integer idAvaliacao;
	
	@Column(name = "ID_CUIDADOR")
	private Integer cuidador;

	public AvaliacaoCuidadorKey(Integer idAvaliacao, Integer cuidador) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.cuidador = cuidador;
	}

	public AvaliacaoCuidadorKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Integer getCuidador() {
		return cuidador;
	}

	public void setCuidador(Integer cuidador) {
		this.cuidador = cuidador;
	}

	@Override
	public String toString() {
		return "AvaliacaoCuidadorKey [idAvaliacao=" + idAvaliacao + ", cuidador=" + cuidador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, idAvaliacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoCuidadorKey other = (AvaliacaoCuidadorKey) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(idAvaliacao, other.idAvaliacao);
	}
	
	
}
