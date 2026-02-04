package com.adorno.control.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.dtos.RequestUpdatePersona;
import com.adorno.modelo.entities.Persona;

@Service
public class PersonaService {
	// Esto hace de repo
	ArrayList<Persona> personas;
	private boolean resultado = false;

	public PersonaService() {
		personas = new ArrayList<>();
		personas.add(new Persona(1, "Ramos", 32));
		personas.add(new Persona(2, "Elias", 24));
		personas.add(new Persona(3, "Julian", 24));
		personas.add(new Persona(4, "Roberto", 24));
	}

	public ArrayList<Persona> getPersonas() {
		return this.personas;
	}

	public boolean addPersona(Persona persona) {
		return this.personas.add(persona);
	}

	public boolean update(int id, RequestUpdatePersona persona) {
		findById(id).ifPresentOrElse(
		(per) -> {
			persona.update(per);
			resultado = true;
		}, 
		() -> {
			resultado = false;
		});
		return resultado;
	}

	private Optional<Persona> findById(int id) {
		return personas.stream().filter((per) -> per.getId() == id).findFirst();
	}

	public boolean delete(int id) {
		return personas.removeIf((per) -> per.getId() == id);
	}
}
