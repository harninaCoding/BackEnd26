package com.adorno.modelo.entities;

import java.util.Objects;

public class Persona {
	//id es de uso interno de la bbdd
    private int id;
    //clave para uso externo
    private String referencia;
    private String  nombre;
    private int edad;
    private String descripcion;
    
	
	public Persona(int id, String referencia, String nombre, int edad, String descripcion) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return Objects.hash(edad, nombre, referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Objects.equals(referencia, other.referencia);
	}

	

	
    
}
