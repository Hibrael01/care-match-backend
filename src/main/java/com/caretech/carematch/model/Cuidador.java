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
@Table(name = "CUIDADOR", schema = "CAREMATCH")
public class Cuidador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_CUIDADOR")
	private Integer idCuidador;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", nullable =  false)
	private Usuario usuario;
	
	@Column(length = 200)
	private String descricao;
	
	private Integer tempoExp;
	
	@Column(length = 1)
	private String unidadeTempo;
	
	@Column(length = 3)
	private String formacao;
	
	@Column(length = 1)
	private String atendeCasa;
	
	@Transient
	private EnderecoCuidador enderecoCuidador;
	
	@Transient
	private List<AvalicaoCuidador> lstAvalicaoCuidador;
	
	@Transient
	private List<ConexaoCuidadorXProcurador> lstConexoes;
	
	@Transient
	private List<CuidadorXCertificado> lstCertificados;
	
	@Transient
	private List<CuidadorXDisponibilidade> lstDisponibilidade;
	
	@Transient
	private List<CuidadorXExperiencia> lstExperiencia;

	public Integer getIdCuidador() {
		return idCuidador;
	}

	public void setIdCuidador(Integer idCuidador) {
		this.idCuidador = idCuidador;
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

	public Integer getTempoExp() {
		return tempoExp;
	}

	public void setTempoExp(Integer tempoExp) {
		this.tempoExp = tempoExp;
	}

	public String getUnidadeTempo() {
		if(unidadeTempo == null) {
			unidadeTempo = "";
		}
		return unidadeTempo;
	}

	public void setUnidadeTempo(String unidadeTempo) {
		this.unidadeTempo = unidadeTempo;
	}

	public String getFormacao() {
		if(formacao == null) {
			formacao = "";
		}
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAtendeCasa() {
		if(atendeCasa == null) {
			atendeCasa = "";
		}
		return atendeCasa;
	}

	public void setAtendeCasa(String atendeCasa) {
		this.atendeCasa = atendeCasa;
	}
	
	public EnderecoCuidador getEnderecoCuidador() {
		if(enderecoCuidador == null) {
			enderecoCuidador = new EnderecoCuidador();
		}
		return enderecoCuidador;
	}

	public void setEnderecoCuidador(EnderecoCuidador enderecoCuidador) {
		this.enderecoCuidador = enderecoCuidador;
	}

	public List<AvalicaoCuidador> getLstAvalicaoCuidador() {
		if(lstAvalicaoCuidador == null) {
			lstAvalicaoCuidador = new ArrayList<AvalicaoCuidador>();
		}
		return lstAvalicaoCuidador;
	}

	public void setLstAvalicaoCuidador(List<AvalicaoCuidador> lstAvalicaoCuidador) {
		this.lstAvalicaoCuidador = lstAvalicaoCuidador;
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

	public List<CuidadorXCertificado> getLstCertificados() {
		if(lstCertificados == null) {
			lstCertificados = new ArrayList<CuidadorXCertificado>();
		}
		return lstCertificados;
	}

	public void setLstCertificados(List<CuidadorXCertificado> lstCertificados) {
		this.lstCertificados = lstCertificados;
	}

	public List<CuidadorXDisponibilidade> getLstDisponibilidade() {
		if(lstDisponibilidade == null) {
			lstDisponibilidade = new ArrayList<CuidadorXDisponibilidade>();
		}
		return lstDisponibilidade;
	}

	public void setLstDisponibilidade(List<CuidadorXDisponibilidade> lstDisponibilidade) {
		this.lstDisponibilidade = lstDisponibilidade;
	}

	public List<CuidadorXExperiencia> getLstExperiencia() {
		if(lstExperiencia == null) {
			lstExperiencia = new ArrayList<CuidadorXExperiencia>();
		}
		return lstExperiencia;
	}

	public void setLstExperiencia(List<CuidadorXExperiencia> lstExperiencia) {
		this.lstExperiencia = lstExperiencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atendeCasa, descricao, formacao, idCuidador, tempoExp, unidadeTempo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuidador other = (Cuidador) obj;
		return Objects.equals(atendeCasa, other.atendeCasa) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(formacao, other.formacao) && Objects.equals(idCuidador, other.idCuidador)
				&& Objects.equals(tempoExp, other.tempoExp) && Objects.equals(unidadeTempo, other.unidadeTempo)
				&& Objects.equals(usuario, other.usuario);
	}

	

}
