package com.adorno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.entities.Persona;
import com.adorno.services.PersonaService;

//con esto le decimos que estamos definiendo un APIREST
@RestController
//Con esto le decimos que este path es necesario en el url
//localhost:8080/asuntos
@RequestMapping(path = "asuntos")
public class PersonaController {
	
	//inyectar el servicio de personas
	private final PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}
	// definiendo los endpoints
	//primero un GET para findbyid
	///localhost:8080/asuntos/persona
	@GetMapping("persona")	
	///localhost:8080/asuntos/persona?id=x
	public Optional< Persona> getPersona(@RequestParam int id) {
		return personaService.findByID(id);
	}
	
	@GetMapping("all")
	public List<Persona> getAll(){
		return personaService.findAll();
	}
	
	@PostMapping("nuevo")
	public boolean addPersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	

}
