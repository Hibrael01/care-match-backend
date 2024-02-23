package com.caretech.carematch.converters;

import java.io.InputStream;
import java.util.stream.Stream;

import com.caretech.carematch.enums.TipoUsuario;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoUsuarioConverter implements AttributeConverter<TipoUsuario, String> {

	@Override
	public String convertToDatabaseColumn(TipoUsuario attribute) {
		if(attribute == null) {
			return "";
		}
		
		return attribute.getTipoUsuario();
		
	}

	@Override
	public TipoUsuario convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}
		
		return Stream.of(TipoUsuario.values())
		.filter(c -> c.getTipoUsuario().equals(dbData))
		.findFirst()
		.orElseThrow(IllegalArgumentException :: new);
	}

}
