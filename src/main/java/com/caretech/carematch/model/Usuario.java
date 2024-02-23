package com.caretech.carematch.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.caretech.carematch.enums.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO", schema = "CAREMATCH")
public class Usuario implements UserDetails {

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
	private TipoUsuario tipoUsuario;

	@Column(length = 90)
	private String email;
	
	@Column(length=20)
	private String telefone;
	
	private LocalDate dtNascimento;
	
	@Column(length = 1)
	private String desabilitado;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.tipoUsuario == TipoUsuario.CUIDADOR) {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
	
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, TipoUsuario tipoUsuario) {
		super();
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

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
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return this.senha;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
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
				&& Objects.equals(telefone, other.telefone) && tipoUsuario == other.tipoUsuario;
	}


	
}
