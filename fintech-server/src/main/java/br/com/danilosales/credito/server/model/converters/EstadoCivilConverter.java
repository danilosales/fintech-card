package br.com.danilosales.credito.server.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.danilosales.credito.server.model.EstadoCivil;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, String>{

	@Override
	public String convertToDatabaseColumn(EstadoCivil estadoCivil) {
		return estadoCivil.getCodigo();
	}

	@Override
	public EstadoCivil convertToEntityAttribute(String code) {
		if(code == null) {
			return null;
		}
		return EstadoCivil.getByCodigo(code);
	}

}
