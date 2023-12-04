package com.caretech.carematch.model;

import java.util.Objects;

import com.caretech.carematch.key.EnderecoCuidadorKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO_CUIDADOR", schema = "CAREMATCH")
public class EnderecoCuidador {
	
	@EmbeddedId
	private EnderecoCuidadorKey id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUIDADOR",  nullable = false, insertable = false, updatable = false)
	private Cuidador cuidador;
	
	@OneToOne
	@JoinColumn(name="ID_CIDADE", nullable = false)
	private Cidade cidade;
	
	@Column(length = 100)
	private String logradouro;

	@Column(length = 100)
	private String bairro;
	
	@Column(length = 100)
	private String complemento;
	
	@Column(length = 1)
	private String acessivel;
	
	@Column(length = 8)
	private String cep;
	
	public EnderecoCuidadorKey getId() {
		return id;
	}

	public void setId(EnderecoCuidadorKey id) {
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

	public String getAcessivel() {
		if(acessivel == null) {
			acessivel = "";
		}
		return acessivel;
	}

	public void setAcessivel(String acessivel) {
		this.acessivel = acessivel;
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
		return Objects.hash(acessivel, bairro, cep, cidade, complemento, cuidador, id, logradouro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoCuidador other = (EnderecoCuidador) obj;
		return Objects.equals(acessivel, other.acessivel) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(cuidador, other.cuidador)
				&& Objects.equals(id, other.id) && Objects.equals(logradouro, other.logradouro);
	}
	
	
	
}
