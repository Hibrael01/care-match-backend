package com.caretech.carematch.model;

import java.sql.Time;
import java.util.Objects;

import com.caretech.carematch.key.CuidadorXDisponibilidadeKey;
import com.caretech.carematch.utils.TimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
@Table(name = "CUIDADOR_X_DISPONIBILIDADE", schema = "CAREMATCH")
public class CuidadorXDisponibilidade {
	
	@Id
	@Column(name = "ID_DISPONIBILIDADE",insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDisponibilidade;
	
	@Column(name = "DIA_SEMANA", length = 2, nullable = false)
	private String diaSemana;
	
	@Column(name ="ID_CUIDADOR")
	private Integer idCuidador;
	
	@Transient
	@JsonIgnore
	private Cuidador cuidador;
	
	@JsonDeserialize(using =  TimeDeserializer.class)
	private Time horaInicial;
	
	@JsonDeserialize(using =  TimeDeserializer.class)
	private Time horaFinal;
	
	@Column(length = 1)
	private String diaInteiro;
	
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
		return Objects.hash(cuidador, diaInteiro, diaSemana, horaFinal, horaInicial, idCuidador, idDisponibilidade);
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
				&& Objects.equals(diaSemana, other.diaSemana) && Objects.equals(horaFinal, other.horaFinal)
				&& Objects.equals(horaInicial, other.horaInicial) && Objects.equals(idCuidador, other.idCuidador)
				&& Objects.equals(idDisponibilidade, other.idDisponibilidade);
	}

	

}
