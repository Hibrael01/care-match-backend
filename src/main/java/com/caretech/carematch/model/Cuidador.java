package com.caretech.carematch.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
