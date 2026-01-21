package com.adorno.objectMother;

import java.util.ArrayList;

import com.adorno.modelo.entities.Persona;

public class PersonaOM {
	public ArrayList<Persona> getPersonas() {
		ArrayList<Persona> personas;
		personas = new ArrayList<>();
		personas.add(new Persona(1,"Ramos", 32));
		personas.add(new Persona(2,"Elias", 24));
		personas.add(new Persona(3,"Julian", 24));
		return personas;
	}
}
