package com.adorno.control.controllers;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.control.services.PersonaService;
import com.adorno.modelo.dtos.Response;

@RestController
@RequestMapping("uno")
public class PruebaController {
	@Autowired
	private PersonaService personaService;

	@GetMapping("respuesta")
	public ResponseEntity<String> getAlgo() throws Exception {
		return ResponseEntity.ok().eTag("respuesta").build();
//		return null;
	}
	@GetMapping("personas")
	public ResponseEntity<Response> getPersonas(){
		return ResponseEntity.ok(
				Response.builder()
					.TimeStamp(LocalDateTime.now())
					.Message("personas recuperadas")
					.Status(HttpStatus.OK)
					.Data(Map.of("personas",personaService.getPersonas()))
					.build()
			);
	}
}
