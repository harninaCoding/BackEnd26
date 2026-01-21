package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.entities.Persona;
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

	public List<Persona> findAll(){
		return personas;
	}
	
	public boolean addPersona(Persona persona) {
		//para que sea idempotente
		if(personas.contains(persona)) return false;
		return personas.add(persona);
	}
}
