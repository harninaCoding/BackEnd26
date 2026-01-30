package com.adorno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.mappers.PersonaPUTDTO2Persona;

@Configuration
public class MappersConfiguration {

	//para que Spring cree un singleton de los conversores
	@Bean
	PersonaPUTDTO2Persona getPersonaPUTDTO2Persona() {
		return new PersonaPUTDTO2Persona();
	}
}
