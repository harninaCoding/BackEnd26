package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.entities.Persona;
import com.adorno.modelo.entities.PersonaPUTDTO;
import com.adorno.objectMother.PersonaOM;

@Service
public class PersonaService {
	ArrayList<Persona> personas;

	public PersonaService() {
		super();
		personas = new PersonaOM().getPersonas();
	}

	public Optional<Persona> findByID(int id) {
		return  personas.stream().filter((per) -> {
			return per.getId() == id;
		}).findFirst();
	}
	public Optional<Persona> findByReferencia(String referencia) {
		return  personas.stream().filter((per) -> {
			return per.getReferencia().equals(referencia);
		}).findFirst();
	}

	public List<Persona> findAll(){
		return personas;
	}
	
	public boolean addPersona(Persona persona) {
		//para que sea idempotente
		if(personas.contains(persona)) return false;
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
		if(byReferencia.isPresent()) {
			Persona persona2 = byReferencia.get();
			persona2.setNombre(persona.getNombre());
			persona2.setEdad(persona.getEdad());
			return true;
		}
		return false;
	}
}
