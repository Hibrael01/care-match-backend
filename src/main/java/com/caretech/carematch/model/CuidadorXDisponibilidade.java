package com.caretech.carematch.model;

import java.sql.Time;
import java.util.Objects;

import com.caretech.carematch.key.CuidadorXDisponibilidadeKey;

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
@Table(name = "CUIDADOR_X_DISPONIBILIDADE", schema = "CAREMATCH")
public class CuidadorXDisponibilidade {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private CuidadorXDisponibilidadeKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUIDADOR",  nullable = false, insertable = false, updatable = false)
	private Cuidador cuidador;
	
	private Time horaInicial;
	
	private Time horaFinal;
	
	@Column(length = 1)
	private String diaInteiro;
	
	public CuidadorXDisponibilidadeKey getId() {
		return id;
	}

	public void setId(CuidadorXDisponibilidadeKey id) {
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

	public Time getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getDiaInteiro() {
		if(diaInteiro == null) {
			diaInteiro = "";
		}
		return diaInteiro;
	}

	public void setDiaInteiro(String diaInteiro) {
		this.diaInteiro = diaInteiro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, diaInteiro, horaFinal, horaInicial, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXDisponibilidade other = (CuidadorXDisponibilidade) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(diaInteiro, other.diaInteiro)
				&& Objects.equals(horaFinal, other.horaFinal) && Objects.equals(horaInicial, other.horaInicial)
				&& Objects.equals(id, other.id);
	}

}
