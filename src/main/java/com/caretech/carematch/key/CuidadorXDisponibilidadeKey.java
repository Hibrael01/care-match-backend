package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class CuidadorXDisponibilidadeKey implements Serializable {
	private static final long serialVersionUID = -3456061924398259589L;

	@Column(name = "ID_DISPONIBILIDADE")
	private Integer idDisponibilidade;
	
	@Column(name = "DIA_SEMANA", length = 2, nullable = false)
	private String diaSemana;
	
	@Column(name ="ID_CUIDADOR")
	private Integer cuidador;

	public CuidadorXDisponibilidadeKey(Integer idDisponibilidade, String diaSemana, Integer cuidador) {
		super();
		this.idDisponibilidade = idDisponibilidade;
		this.diaSemana = diaSemana;
		this.cuidador = cuidador;
	}

	public CuidadorXDisponibilidadeKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdDisponibilidade() {
		return idDisponibilidade;
	}

	public void setIdDisponibilidade(Integer idDisponibilidade) {
		this.idDisponibilidade = idDisponibilidade;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getCuidador() {
		return cuidador;
	}

	public void setCuidador(Integer cuidador) {
		this.cuidador = cuidador;
	}

	@Override
	public String toString() {
		return "CuidadorXDisponibilidadeKey [idDisponibilidade=" + idDisponibilidade + ", diaSemana=" + diaSemana
				+ ", cuidador=" + cuidador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, diaSemana, idDisponibilidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXDisponibilidadeKey other = (CuidadorXDisponibilidadeKey) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(diaSemana, other.diaSemana)
				&& Objects.equals(idDisponibilidade, other.idDisponibilidade);
	}
	
}
