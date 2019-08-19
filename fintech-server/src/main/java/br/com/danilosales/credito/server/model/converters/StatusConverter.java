package br.com.danilosales.credito.server.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.danilosales.credito.server.model.Status;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String>{

	@Override
	public String convertToDatabaseColumn(Status status) {
		return status.getCodigo();
	}

	@Override
	public Status convertToEntityAttribute(String code) {
		if(code == null) {
			return null;
		}
		return Status.getByCodigo(code);
	}

}
