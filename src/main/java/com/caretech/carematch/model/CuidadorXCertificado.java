package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import com.caretech.carematch.key.CuidadorXCertificadoKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "CUIDADOR_X_CERTIFICADO", schema = "CAREMATCH")
public class CuidadorXCertificado {
	
	@Id
	@Column(name = "ID_CERTIFICADO", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCertificado;
	
	@Column(name ="ID_CUIDADOR")
	private Integer idCuidador;
	
	@Transient
	@JsonIgnore
	private Cuidador cuidador;

	@Column(length = 200)
	private String instituicao;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	@Column(length = 200)
	private String linkCertificado;
	
	public Integer getIdCertificado() {
		return idCertificado;
	}

	public void setIdCertificado(Integer idCertificado) {
		this.idCertificado = idCertificado;
	}

	public Integer getIdCuidador() {
		return idCuidador;
	}

	public void setIdCuidador(Integer idCuidador) {
		this.idCuidador = idCuidador;
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

	public String getInstituicao() {
		if(instituicao == null) {
			instituicao = "";
		}
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getLinkCertificado() {
		if(linkCertificado == null) {
			linkCertificado = "";
		}
		return linkCertificado;
	}

	public void setLinkCertificado(String linkCertificado) {
		this.linkCertificado = linkCertificado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, dataFinal, dataInicial, idCertificado, idCuidador, instituicao, linkCertificado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXCertificado other = (CuidadorXCertificado) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(dataFinal, other.dataFinal)
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(idCertificado, other.idCertificado)
				&& Objects.equals(idCuidador, other.idCuidador) && Objects.equals(instituicao, other.instituicao)
				&& Objects.equals(linkCertificado, other.linkCertificado);
	}

	
}
