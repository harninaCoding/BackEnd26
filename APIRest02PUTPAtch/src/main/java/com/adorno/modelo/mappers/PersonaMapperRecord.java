package com.adorno.modelo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.adorno.modelo.entities.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapperRecord {
	PersonaMapperRecord mapToDTO(Persona persona);

	@Mapping(target = "id",ignore = true)
	Persona mapToEntity(PersonaMapperRecord personaMapperRecord);
}
