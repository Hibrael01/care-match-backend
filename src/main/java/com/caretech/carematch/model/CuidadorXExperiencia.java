package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.cglib.core.Local;

import com.caretech.carematch.key.CuidadorXExperienciaKey;

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
@Table(name = "CUIDADOR_X_EXPERIENCIA", schema = "CAREMATCH")
public class CuidadorXExperiencia {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private CuidadorXExperienciaKey id;
	
	@ManyToOne
	 @JoinColumn(name = "ID_CUIDADOR", referencedColumnName = "ID_CUIDADOR", insertable = false, updatable = false)
	private Cuidador cuidador;
	
	@Column(length = 200)
	private String descricao;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	@Column(length = 80)
	private String local;
	
	private Integer qtdPessoas;

	public CuidadorXExperienciaKey getId() {
		return id;
	}

	public void setId(CuidadorXExperienciaKey id) {
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
		return Objects.hash(cuidador, dataFinal, dataInicial, descricao, id, local, qtdPessoas);
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
				&& Objects.equals(id, other.id) && Objects.equals(local, other.local)
				&& Objects.equals(qtdPessoas, other.qtdPessoas);
	}

	
	
}
