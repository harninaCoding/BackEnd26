package com.adorno.modelo.dtos;

import java.util.Optional;

import com.adorno.modelo.entities.Persona;

//https://www.baeldung.com/spring-data-partial-update
public class RequestUpdatePersona implements RequestUpdate<Persona>{
	//omito el id porque ahora quiero deciros como se haria
	//si hubiese atributos no modificables
	private Optional<String> nombre;
	private Optional<Integer> edad;
	
	public RequestUpdatePersona(Optional<String> nombre, Optional<Integer> edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public void update(Persona t) {
		nombre.ifPresent((contenido)->t.setNombre(contenido));
		edad.ifPresent((contenido)->t.setEdad(contenido));
	}
	
}
