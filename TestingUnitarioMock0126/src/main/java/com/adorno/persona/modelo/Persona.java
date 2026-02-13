package com.adorno.persona.modelo;

public class Persona {

	private int id;
	private String nombre;
	// Para que no lleguen a json
//    @JsonIgnore
	//	Para que no se mapeen a la base de datos
//	@Transient
	private int edad;
	private String color;

//	public Persona(int id, String nombre, int edad) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.edad = edad;
//	}
//	

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona(String nombre, int edad, String color) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.color = color;
	}

	public Persona() {
		super();
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
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

}
