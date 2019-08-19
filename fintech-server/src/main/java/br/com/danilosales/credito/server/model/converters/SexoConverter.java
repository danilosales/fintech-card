package br.com.danilosales.credito.server.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.danilosales.credito.server.model.Sexo;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String>{

	@Override
	public String convertToDatabaseColumn(Sexo sexo) {
		return sexo.getCodigo();
	}

	@Override
	public Sexo convertToEntityAttribute(String code) {
		if(code == null) {
			return null;
		}
		return Sexo.getByCodigo(code);
	}

}
