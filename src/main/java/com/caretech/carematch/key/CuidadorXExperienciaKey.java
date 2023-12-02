package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class CuidadorXExperienciaKey implements Serializable {
	private static final long serialVersionUID = 3318158047667766391L;

	@Column(name = "ID_EXPERIENCIA")
	private Integer idExperiencia;
	
	@Column(name ="ID_CUIDADOR")
	private Integer cuidador;

	public CuidadorXExperienciaKey(Integer idExperiencia, Integer cuidador) {
		super();
		this.idExperiencia = idExperiencia;
		this.cuidador = cuidador;
	}

	public CuidadorXExperienciaKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Integer getCuidador() {
		return cuidador;
	}

	public void setCuidador(Integer cuidador) {
		this.cuidador = cuidador;
	}

	@Override
	public String toString() {
		return "CuidadorXExperienciaKey [idExperiencia=" + idExperiencia + ", cuidador=" + cuidador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, idExperiencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXExperienciaKey other = (CuidadorXExperienciaKey) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(idExperiencia, other.idExperiencia);
	}

	
	
}
