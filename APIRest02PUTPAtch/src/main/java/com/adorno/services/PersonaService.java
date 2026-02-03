package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.DTOS.PersonaPATCHDTO;
import com.adorno.modelo.DTOS.PersonaPUTDTO;
import com.adorno.modelo.entities.Persona;
import com.adorno.modelo.mappers.PersonaPAtchDTO2PErsonaConverter;
import com.adorno.modelo.mappers.PersonaPUTDTO2Persona;
import com.adorno.objectMother.PersonaOM;

@Service
public class PersonaService {
	private ArrayList<Persona> personas;
	private final PersonaPUTDTO2Persona personaPUTDTO2Persona;
	private final PersonaPAtchDTO2PErsonaConverter personaConverter;

	public PersonaService(PersonaPUTDTO2Persona personaPUTDTO2Persona, PersonaPAtchDTO2PErsonaConverter personaConverter) {
		super();
		personas = new PersonaOM().getPersonas();
		this.personaPUTDTO2Persona=personaPUTDTO2Persona;
		this.personaConverter = personaConverter;
	}

	public Optional<Persona> findByID(int id) {
		return personas.stream().filter((per) -> {
			return per.getId() == id;
		}).findFirst();
	}

	public Optional<Persona> findByReferencia(String referencia) {
		return personas.stream().filter((per) -> {
			return per.getReferencia().equals(referencia);
		}).findFirst();
	}

	public List<Persona> findAll() {
		return personas;
	}

	public boolean addPersona(Persona persona) {
		// para que sea idempotente
		if (personas.contains(persona))
			return false;
		return personas.add(persona);
	}

	public Optional<Persona> borrar(int id) {
		Optional<Persona> byID = findByID(id);
		if (byID.isPresent()) {
			if (personas.remove(byID.get()))
				return byID;
		}
		return Optional.empty();
	}

	public boolean update(String referencia, PersonaPUTDTO persona) {
		Optional<Persona> byReferencia = findByReferencia(referencia);
		if (byReferencia.isPresent()) {
			personaPUTDTO2Persona.convert(byReferencia.get(), persona);
			return true;
		}
		return false;
	}

	public boolean partialUpdate(String referencia, PersonaPATCHDTO personaPATCHDTO) {
		Optional<Persona> byReferencia = findByReferencia(referencia);
		if (byReferencia.isEmpty())
			return false;
		Persona persona = byReferencia.get();
		personaConverter.convert(persona, personaPATCHDTO);
		return true;
	}
}
