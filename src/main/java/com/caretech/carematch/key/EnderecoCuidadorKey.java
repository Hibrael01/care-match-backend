package com.caretech.carematch.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Embeddable
public class EnderecoCuidadorKey  implements Serializable{
	private static final long serialVersionUID = 6080465718789493955L;

	@Column(name = "ID_ENDERECO")
	private Integer idEndereco;
	
	@Column(name ="ID_CUIDADOR")
	private Integer cuidador;

	public EnderecoCuidadorKey(Integer idEndereco, Integer cuidador) {
		super();
		this.idEndereco = idEndereco;
		this.cuidador = cuidador;
	}

	public EnderecoCuidadorKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Integer getCuidador() {
		return cuidador;
	}

	public void setCuidador(Integer cuidador) {
		this.cuidador = cuidador;
	}

	@Override
	public String toString() {
		return "EnderecoCuidadorKey [idEndereco=" + idEndereco + ", cuidador=" + cuidador + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, idEndereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoCuidadorKey other = (EnderecoCuidadorKey) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(idEndereco, other.idEndereco);
	}
	
	
	
}
