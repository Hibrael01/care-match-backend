package com.caretech.carematch.model;

import java.util.Objects;

import com.caretech.carematch.key.EnderecoProcuradorKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO_PROCURADOR", schema = "CAREMATCH")
public class EnderecoProcurador {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private EnderecoProcuradorKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROCURADOR",  nullable = false,  insertable = false, updatable = false)
	private Procurador procurador;
	
	@OneToOne
	@JoinColumn(name="ID_CIDADE", nullable = false)
	private Cidade cidade;
	
	@Column(length = 100)
	private String logradouro;

	@Column(length = 100)
	private String bairro;
	
	@Column(length = 100)
	private String complemento;
	
	@Column(length = 8)
	private String cep;
	
	public EnderecoProcuradorKey getId() {
		return id;
	}

	public void setId(EnderecoProcuradorKey id) {
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

	public Cidade getCidade() {
		if(cidade == null) {
			cidade = new Cidade();
		}
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		if(logradouro == null) {
			logradouro = "";
		}
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		if(bairro == null) {
			bairro = "";
		}
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		if(complemento == null) {
			complemento = "";
		}
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		if(cep == null) {
			cep = "";
		}
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, id, logradouro, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoProcurador other = (EnderecoProcurador) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(id, other.id) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(procurador, other.procurador);
	}

	
	
	
	
}
