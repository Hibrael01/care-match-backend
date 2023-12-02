package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO", schema = "CAREMATCH")
public class Usuario {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Integer idUsuario;
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 90)
	private String sobrenome;
	
	@Column(length = 30)
	private String login;
	
	@Column(length = 60)
	private String senha;
	
	private LocalDate dtCriacao;
	
	@Column(length = 80)
	private String sessionToken;
	
	@Column(length = 1)
	private String tipoUsuario;

	@Column(length = 90)
	private String email;
	
	@Column(length=20)
	private String telefone;
	
	private LocalDate dtNascimento;
	
	@Column(length = 1)
	private String desabilitado;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		if(nome == null) {
			nome = "";
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		if(sobrenome == null){
			sobrenome = "";
		}
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		if(login == null) {
			login = "";
		}
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		if(senha == null) {
			senha = "";
		}
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDate dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getSessionToken() {
		if(sessionToken == null) {
			sessionToken = "";
		}
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getTipoUsuario() {
		if(tipoUsuario == null) {
			tipoUsuario = "";
		}
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		if(email == null) {
			email = "";
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		if(telefone == null) {
			telefone = "";
		}
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getDesabilitado() {
		if(desabilitado == null) {
			desabilitado = "";
		}
		return desabilitado;
	}

	public void setDesabilitado(String desabilitado) {
		this.desabilitado = desabilitado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desabilitado, dtCriacao, dtNascimento, email, idUsuario, login, nome, senha, sessionToken,
				sobrenome, telefone, tipoUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(desabilitado, other.desabilitado) && Objects.equals(dtCriacao, other.dtCriacao)
				&& Objects.equals(dtNascimento, other.dtNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(idUsuario, other.idUsuario) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(sessionToken, other.sessionToken) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(tipoUsuario, other.tipoUsuario);
	}
	
	
}
