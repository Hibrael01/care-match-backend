package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.cglib.core.Local;

import com.caretech.carematch.key.CuidadorXExperienciaKey;
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
@Table(name = "CUIDADOR_X_EXPERIENCIA", schema = "CAREMATCH")
public class CuidadorXExperiencia {
	
	@Id
	@Column(name = "ID_EXPERIENCIA", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idExperiencia;
	
	@Column(name ="ID_CUIDADOR")
	private Integer idCuidador;
	
	@Transient
	@JsonIgnore
	private Cuidador cuidador;
	
	@Column(length = 200)
	private String descricao;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	@Column(length = 80)
	private String local;
	
	private Integer qtdPessoas;

	public Integer getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
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

	public String getDescricao() {
		if(descricao == null) {
			descricao = "";
		}
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getLocal() {
		if(local == null) {
			local = "";
		}
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, dataFinal, dataInicial, descricao, idCuidador, idExperiencia, local, qtdPessoas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuidadorXExperiencia other = (CuidadorXExperiencia) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(dataFinal, other.dataFinal)
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(idCuidador, other.idCuidador) && Objects.equals(idExperiencia, other.idExperiencia)
				&& Objects.equals(local, other.local) && Objects.equals(qtdPessoas, other.qtdPessoas);
	}	
	
}
