package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class EnderecoProcuradorKey implements Serializable {
	private static final long serialVersionUID = -7214406648312450606L;

	@Column(name = "ID_ENDERECO")
	private Integer idEndereco;
	
	@Column(name = "ID_PROCURADOR")
	private Integer procurador;

	public EnderecoProcuradorKey(Integer idEndereco, Integer procurador) {
		super();
		this.idEndereco = idEndereco;
		this.procurador = procurador;
	}

	public EnderecoProcuradorKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Integer getProcurador() {
		return procurador;
	}

	public void setProcurador(Integer procurador) {
		this.procurador = procurador;
	}

	@Override
	public String toString() {
		return "EnderecoProcuradorKey [idEndereco=" + idEndereco + ", procurador=" + procurador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEndereco, procurador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoProcuradorKey other = (EnderecoProcuradorKey) obj;
		return Objects.equals(idEndereco, other.idEndereco) && Objects.equals(procurador, other.procurador);
	}
	
	
	
}
