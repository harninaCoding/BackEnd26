package com.adorno.modelo.entities;

import java.util.Objects;

public class PersonaPUTDTO {
	 //clave para uso externo
    private String  nombre;
    private int edad;
    
	public PersonaPUTDTO(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaPUTDTO other = (PersonaPUTDTO) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
    
	
}
