package com.adorno.objectMother;

import java.util.ArrayList;

import com.adorno.modelo.entities.Persona;

public class PersonaOM {
	public ArrayList<Persona> getPersonas() {
		ArrayList<Persona> personas;
		personas = new ArrayList<>();
		personas.add(new Persona(1,"1","Ramos", 32,"uno"));
		personas.add(new Persona(2,"2","Elias", 24,"dos"));
		personas.add(new Persona(3,"3","Julian", 24,"tres"));
		return personas;
	}
}
