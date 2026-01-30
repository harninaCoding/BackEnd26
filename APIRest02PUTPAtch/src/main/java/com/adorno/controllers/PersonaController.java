package com.adorno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.DTOS.PersonaPATCHDTO;
import com.adorno.modelo.DTOS.PersonaPUTDTO;
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
	
	//tambien deberia ser personaDTO
	@PostMapping("nuevo")
	public boolean addPersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	
	@DeleteMapping("persona")
	public Optional<Persona> delete(@RequestParam int id){
		return personaService.borrar(id);
	}
	
	//Susititucion completa de recurso
	@PutMapping("sustituto")
	public boolean actualizarCompletamente(@RequestParam String referencia, @RequestBody PersonaPUTDTO persona) {
		return personaService.update(referencia,persona);
	}
	
	//actualizacion parcial
	@PatchMapping("actualizacion")
	public boolean actualizarParcial(@RequestParam String referencia,@RequestBody PersonaPATCHDTO personaPATCHDTO) {
		return personaService.partialUpdate(referencia,personaPATCHDTO);
	}
}
