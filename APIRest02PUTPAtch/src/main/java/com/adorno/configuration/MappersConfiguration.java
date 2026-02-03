package com.adorno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.DTOS.PersonaPATCHDTO;
import com.adorno.modelo.mappers.PersonaPAtchDTO2PErsonaConverter;
import com.adorno.modelo.mappers.PersonaPUTDTO2Persona;

@Configuration
public class MappersConfiguration {

	//para que Spring cree un singleton de los conversores
	@Bean
	PersonaPUTDTO2Persona getPersonaPUTDTO2Persona() {
		return new PersonaPUTDTO2Persona();
	}
	@Bean
	PersonaPAtchDTO2PErsonaConverter getPersonaPAtchDTO2PErsonaConverter() {
		return new PersonaPAtchDTO2PErsonaConverter();
	}
}
