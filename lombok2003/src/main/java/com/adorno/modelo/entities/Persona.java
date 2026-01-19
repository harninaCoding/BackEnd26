package com.adorno.modelo.entities;

import lombok.Builder;
import lombok.Data;

@Data
public class Persona {
	private String nombre;
	private String apellidos;
	private String direccion;
}
