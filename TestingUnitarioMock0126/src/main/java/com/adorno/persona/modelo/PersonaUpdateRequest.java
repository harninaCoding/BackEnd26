package com.adorno.persona.modelo;

import java.util.Optional;



//Igual esto solo es necesario si no cargo el objeto en la busqueda
//habra campos no 
public class PersonaUpdateRequest {

	private Optional<String> nombre;
	private Optional<Integer> edad;

	public PersonaUpdateRequest(Optional<String> nombre, Optional<Integer> edad) {
		super();
		this.nombre=nombre;
		this.edad=edad;
	}

	public void updatePersona(Persona persona) {
		nombre.ifPresent((contenido)->persona.setNombre(contenido));
		edad.ifPresent((contenido)->persona.setEdad(contenido));		
	}
}
//public class PersonaUpdateRequest {
//
//	private String nombre;
//	private Integer edad;
//
//
//	public PersonaUpdateRequest(String nombre, Integer edad) {
//		super();
//		this.nombre=nombre;
//		this.edad=edad;
//	}
//
//	public void updatePersona(Persona persona) {
//	
//		if(nombre!=null)
//			persona.setNombre(nombre);
//		if(edad!=null) {
//			persona.setEdad(edad);
//		}
//	}
//}
//class Pair<T>{
//	public T value;
//	public boolean modified;
//}
//
//public class PersonaUpdateRequest {
//	
//	private Pair<String> nombre;
//	private Pair<Integer> edad;
//	
//	
//	public PersonaUpdateRequest(Pair<String> nombre, Pair<Integer> edad) {
//		super();
//		this.nombre=nombre;
//		this.edad=edad;
//	}
//	
//	public void updatePersona(Persona persona) {
//		
//		if(nombre.modified)
//			persona.setNombre(nombre.value);
//		if(edad.modified) {
//			persona.setEdad(edad.value);
//		}
//	}
//}
