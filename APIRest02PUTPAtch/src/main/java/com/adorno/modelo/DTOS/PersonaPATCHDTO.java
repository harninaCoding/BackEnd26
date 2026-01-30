package com.adorno.modelo.DTOS;

public class PersonaPATCHDTO {
	private final String nombre;
	private final Integer edad;
	private final String descripcion;
	
	public PersonaPATCHDTO(String nombre, Integer edad, String descripcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
