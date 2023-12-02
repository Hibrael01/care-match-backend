package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import com.caretech.carematch.key.CuidadorXCertificadoKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUIDADOR_X_CERTIFICADO", schema = "CAREMATCH")
public class CuidadorXCertificado {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private CuidadorXCertificadoKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUIDADOR",  nullable = false, insertable = false, updatable = false)
	private Cuidador cuidador;

	@Column(length = 200)
	private String instituicao;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	@Column(length = 200)
	private String linkCertificado;
	
	public CuidadorXCertificadoKey getId() {
		return id;
	}

	public void setId(CuidadorXCertificadoKey id) {
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
		return Objects.hash(cuidador, dataFinal, dataInicial, id, instituicao, linkCertificado);
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
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(id, other.id)
				&& Objects.equals(instituicao, other.instituicao)
				&& Objects.equals(linkCertificado, other.linkCertificado);
	}

	
}
