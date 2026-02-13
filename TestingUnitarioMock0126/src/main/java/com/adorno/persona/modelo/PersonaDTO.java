package com.adorno.persona.modelo;

public class PersonaDTO {
	private String nombre;
	private int edad;
	
	
	public PersonaDTO(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

//
//	public String getNombre() {
//		return nombre;
//	}
//
//
//	public int getEdad() {
//		return edad;
//	}


	//Si usamos @Mapper no puedes tener un constructor vacio
//	public PersonaDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	
	
}
