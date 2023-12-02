package com.caretech.carematch.model;

import java.util.Objects;

import com.caretech.carematch.key.AvaliacaoCuidadorKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AVALIACAO_CUIDADOR", schema = "CAREMATCH")
public class AvalicaoCuidador {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private AvaliacaoCuidadorKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUIDADOR",  nullable = false, insertable = false, updatable = false)
	private Cuidador cuidador;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROCURADOR",  nullable = false,  insertable = false, updatable = false)
	private Procurador procurador;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONEXAO", nullable = false)
	private ConexaoCuidadorXProcurador conexao;
	
	@Column(length = 200)
	private String observacao;
	
	private Integer avaliacao;
	
	public AvaliacaoCuidadorKey getId() {
		return id;
	}

	public void setId(AvaliacaoCuidadorKey id) {
		this.id = id;
	}

	public Cuidador getCuidador() {
		if(cuidador == null) {
			cuidador = new Cuidador();
		}
		return cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Procurador getProcurador() {
		if(procurador == null) {
			procurador = new Procurador();
		}
		return procurador;
	}

	public void setProcurador(Procurador procurador) {
		this.procurador = procurador;
	}

	public ConexaoCuidadorXProcurador getConexao() {
		if(conexao == null) {
			conexao = new ConexaoCuidadorXProcurador();
		}
		return conexao;
	}

	public void setConexao(ConexaoCuidadorXProcurador conexao) {
		this.conexao = conexao;
	}

	public String getObservacao() {
		if(observacao == null) {
			observacao = "";
		}
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avaliacao, conexao, cuidador, id, observacao, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvalicaoCuidador other = (AvalicaoCuidador) obj;
		return Objects.equals(avaliacao, other.avaliacao) && Objects.equals(conexao, other.conexao)
				&& Objects.equals(cuidador, other.cuidador) && Objects.equals(id, other.id)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(procurador, other.procurador);
	}

}
