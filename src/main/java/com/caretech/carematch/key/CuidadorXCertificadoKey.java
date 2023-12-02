package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class CuidadorXCertificadoKey implements Serializable {
	private static final long serialVersionUID = 4937463614528411350L;

	@Column(name = "ID_CERTIFICADO")
	private Integer idCertificado;
	
	@Column(name ="ID_CUIDADOR")
	private Integer cuidador;

	public CuidadorXCertificadoKey(Integer idCertificado, Integer cuidador) {
		super();
		this.idCertificado = idCertificado;
		this.cuidador = cuidador;
	}

	public CuidadorXCertificadoKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCertificado() {
		return idCertificado;
	}

	public void setIdCertificado(Integer idCertificado) {
		this.idCertificado = idCertificado;
	}

	public Integer getCuidador() {
		return cuidador;
	}

	public void setCuidador(Integer cuidador) {
		this.cuidador = cuidador;
	}

	@Override
	public String toString() {
		return "CuidadorXCertificadoKey [idCertificado=" + idCertificado + ", cuidador=" + cuidador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, idCertificado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXCertificadoKey other = (CuidadorXCertificadoKey) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(idCertificado, other.idCertificado);
	}
	
}
