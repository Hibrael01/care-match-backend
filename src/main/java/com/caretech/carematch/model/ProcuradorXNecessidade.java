package com.caretech.carematch.model;

import java.sql.Time;
import java.util.Objects;

import com.caretech.carematch.key.ProcuradorXNecessidadeKey;

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
@Table(name = "PROCURADOR_X_NECESSIDADE", schema = "CAREMATCH")
public class ProcuradorXNecessidade {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private ProcuradorXNecessidadeKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROCURADOR",  nullable = false, insertable = false, updatable = false)
	private Procurador procurador;
	
	private Time horaInicial;
	
	private Time horaFinal;
	
	@Column(length = 1)
	private String integral;
	
	public ProcuradorXNecessidadeKey getId() {
		return id;
	}

	public void setId(ProcuradorXNecessidadeKey id) {
		this.id = id;
	}

	public Procurador getProcurador() {
		if(procurador == null) {
			procurador = new Procurador();
		}
		return procurador;
	}

	public void setProcurador(Procurador procurador) {
		this.procurador = procurador;
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

	public String getIntegral() {
		if(integral == null) {
			integral = "";
		}
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horaFinal, horaInicial, id, integral, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcuradorXNecessidade other = (ProcuradorXNecessidade) obj;
		return Objects.equals(horaFinal, other.horaFinal) && Objects.equals(horaInicial, other.horaInicial)
				&& Objects.equals(id, other.id) && Objects.equals(integral, other.integral)
				&& Objects.equals(procurador, other.procurador);
	}

	

	

}
