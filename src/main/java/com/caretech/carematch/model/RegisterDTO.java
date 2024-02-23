package com.caretech.carematch.model;

import com.caretech.carematch.enums.TipoUsuario;

public record RegisterDTO(String login, String senha, TipoUsuario tipoUsuario) {

}
