package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONEXAO_CUIDADOR_X_PROCURADOR", schema = "CAREMATCH")
public class ConexaoCuidadorXProcurador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idConexao;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROCURADOR",  nullable = false,  insertable = false, updatable = false)
	private Procurador procurador;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUIDADOR",  nullable = false,  insertable = false, updatable = false)
	private Cuidador cuidador;
	
	private LocalDate dataConexao;
	
	@Column(length = 200)
	private String justificativaProcurador;
	
	@Column(length = 200)
	private String justificativaCuidador;
	
	@Column(length = 3)
	private String status;
	
	@OneToOne
	@JoinColumn(name = "ID_MOTIVO", nullable = false,  insertable = false, updatable = false)
	private MotivoCancelamento motivoCancelamento1;
	
	@OneToOne
	@JoinColumn(name = "ID_MOTIVO", nullable = false,  insertable = false, updatable = false)
	private MotivoCancelamento motivoCancelamento2;
	
	@OneToOne
	@JoinColumn(name = "ID_MOTIVO", nullable = false,  insertable = false, updatable = false)
	private MotivoCancelamento motivoCancelamento3;

	public Integer getIdConexao() {
		return idConexao;
	}

	public void setIdConexao(Integer idConexao) {
		this.idConexao = idConexao;
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

	public Cuidador getCuidador() {
		if(cuidador == null) {
			cuidador = new Cuidador();
		}
		return cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public LocalDate getDataConexao() {
		return dataConexao;
	}

	public void setDataConexao(LocalDate dataConexao) {
		this.dataConexao = dataConexao;
	}

	public String getJustificativaProcurador() {
		if(justificativaProcurador == null) {
			justificativaProcurador = "";
		}
		return justificativaProcurador;
	}

	public void setJustificativaProcurador(String justificativaProcurador) {
		this.justificativaProcurador = justificativaProcurador;
	}

	public String getJustificativaCuidador() {
		if(justificativaCuidador == null) {
			justificativaCuidador = "";
		}
		return justificativaCuidador;
	}

	public void setJustificativaCuidador(String justificativaCuidador) {
		this.justificativaCuidador = justificativaCuidador;
	}

	public String getStatus() {
		if(status == null) {
			status = "";
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MotivoCancelamento getMotivoCancelamento1() {
		if(motivoCancelamento1 == null) {
			motivoCancelamento1 = new MotivoCancelamento();
		}
		return motivoCancelamento1;
	}

	public void setMotivoCancelamento1(MotivoCancelamento motivoCancelamento1) {
		this.motivoCancelamento1 = motivoCancelamento1;
	}

	public MotivoCancelamento getMotivoCancelamento2() {
		if(motivoCancelamento2 == null) {
			motivoCancelamento2 = new MotivoCancelamento();
		}
		return motivoCancelamento2;
	}

	public void setMotivoCancelamento2(MotivoCancelamento motivoCancelamento2) {
		this.motivoCancelamento2 = motivoCancelamento2;
	}

	public MotivoCancelamento getMotivoCancelamento3() {
		if(motivoCancelamento3 == null) {
			motivoCancelamento3 = new MotivoCancelamento();
		}
		return motivoCancelamento3;
	}

	public void setMotivoCancelamento3(MotivoCancelamento motivoCancelamento3) {
		this.motivoCancelamento3 = motivoCancelamento3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuidador, dataConexao, idConexao, justificativaCuidador, justificativaProcurador,
				motivoCancelamento1, motivoCancelamento2, motivoCancelamento3, procurador, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConexaoCuidadorXProcurador other = (ConexaoCuidadorXProcurador) obj;
		return Objects.equals(cuidador, other.cuidador) && Objects.equals(dataConexao, other.dataConexao)
				&& Objects.equals(idConexao, other.idConexao)
				&& Objects.equals(justificativaCuidador, other.justificativaCuidador)
				&& Objects.equals(justificativaProcurador, other.justificativaProcurador)
				&& Objects.equals(motivoCancelamento1, other.motivoCancelamento1)
				&& Objects.equals(motivoCancelamento2, other.motivoCancelamento2)
				&& Objects.equals(motivoCancelamento3, other.motivoCancelamento3)
				&& Objects.equals(procurador, other.procurador) && Objects.equals(status, other.status);
	}
	
	
}
