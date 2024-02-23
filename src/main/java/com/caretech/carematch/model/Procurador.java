package com.caretech.carematch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "PROCURADOR", schema = "CAREMATCH")
public class Procurador {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Integer idProcurador;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", nullable =  false)
	private Usuario usuario;
	
	@Column(length = 200)
	private String descricao;
	
	@Column(length = 200)
	private String resumoNecessidade;
	
	@Transient
	private EnderecoProcurador enderecoProcurador;
	
	@Transient 
	private List<AvaliacaoProcurador> lstAvalicaoProcurador;
	
	@Transient
	private List<ConexaoCuidadorXProcurador> lstConexoes;
	
	@Transient
	private List<ProcuradorXNecessidade> lstProcuradorXNecessidade;

	public Integer getIdProcurador() {
		return idProcurador;
	}

	public void setIdProcurador(Integer idProcurador) {
		this.idProcurador = idProcurador;
	}

	public Usuario getUsuario() {
		if(usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		if(descricao == null) {
			descricao = "";
		}
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResumoNecessidade() {
		if(resumoNecessidade == null) {
			resumoNecessidade = "";
		}
		return resumoNecessidade;
	}

	public void setResumoNecessidade(String resumoNecessidade) {
		this.resumoNecessidade = resumoNecessidade;
	}
	
	

	public EnderecoProcurador getEnderecoProcurador() {
		if(enderecoProcurador == null) {
			enderecoProcurador = new EnderecoProcurador();
		}
		return enderecoProcurador;
	}

	public void setEnderecoProcurador(EnderecoProcurador enderecoProcurador) {
		this.enderecoProcurador = enderecoProcurador;
	}

	public List<AvaliacaoProcurador> getLstAvalicaoProcurador() {
		if(lstAvalicaoProcurador == null) {
			lstAvalicaoProcurador = new ArrayList<AvaliacaoProcurador>();
		}
		return lstAvalicaoProcurador;
	}

	public void setLstAvalicaoProcurador(List<AvaliacaoProcurador> lstAvalicaoProcurador) {
		this.lstAvalicaoProcurador = lstAvalicaoProcurador;
	}

	public List<ConexaoCuidadorXProcurador> getLstConexoes() {
		if(lstConexoes == null) {
			lstConexoes = new ArrayList<ConexaoCuidadorXProcurador>();
		}
		return lstConexoes;
	}

	public void setLstConexoes(List<ConexaoCuidadorXProcurador> lstConexoes) {
		this.lstConexoes = lstConexoes;
	}

	public List<ProcuradorXNecessidade> getLstProcuradorXNecessidade() {
		if(lstProcuradorXNecessidade == null) {
			lstProcuradorXNecessidade = new ArrayList<ProcuradorXNecessidade>();
		}
		return lstProcuradorXNecessidade;
	}

	public void setLstProcuradorXNecessidade(List<ProcuradorXNecessidade> lstProcuradorXNecessidade) {
		this.lstProcuradorXNecessidade = lstProcuradorXNecessidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, idProcurador, resumoNecessidade, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procurador other = (Procurador) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(idProcurador, other.idProcurador)
				&& Objects.equals(resumoNecessidade, other.resumoNecessidade) && Objects.equals(usuario, other.usuario);
	}
	
	
	
}
