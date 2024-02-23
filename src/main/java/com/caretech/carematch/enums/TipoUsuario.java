package com.caretech.carematch.enums;

public enum TipoUsuario {
	
	CUIDADOR("C"),
	
	PROCURADOR("P");
	
	private String tipoUsuario;
	
	TipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
}
