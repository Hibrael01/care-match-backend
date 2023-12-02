package com.caretech.carematch.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "MOTIVO_CANCELAMENTO", schema = "CAREMATCH")
public class MotivoCancelamento {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Integer idMotivo;
	
	@Column(nullable = true,  length = 80)
	private String descricao;

	public Integer getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
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

	@Override
	public int hashCode() {
		return Objects.hash(descricao, idMotivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotivoCancelamento other = (MotivoCancelamento) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(idMotivo, other.idMotivo);
	}

	@Override
	public String toString() {
		return "MotivoCancelamento [idMotivo=" + idMotivo + ", descricao=" + descricao + "]";
	}
	
}
