package com.adorno.modelo.mappers;

import com.adorno.modelo.DTOS.PersonaPATCHDTO;
import com.adorno.modelo.entities.Persona;

public class PersonaPAtchDTO2PErsonaConverter implements MyConverter<Persona, PersonaPATCHDTO> {

	@Override
	public void convert(Persona persona, PersonaPATCHDTO personaPATCHDTO) {
		if (personaPATCHDTO.getNombre() != null)
			persona.setNombre(personaPATCHDTO.getNombre());
		if (personaPATCHDTO.getEdad() != null)
			persona.setEdad(personaPATCHDTO.getEdad());
		if (personaPATCHDTO.getDescripcion() != null)
			persona.setDescripcion(personaPATCHDTO.getDescripcion());
		
	}

}
