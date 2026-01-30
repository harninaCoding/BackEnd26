package com.adorno.modelo.mappers;

import com.adorno.modelo.DTOS.PersonaPUTDTO;
import com.adorno.modelo.entities.Persona;

public class PersonaPUTDTO2Persona implements MyConverter<Persona, PersonaPUTDTO> {

	@Override
	public void convert(Persona t, PersonaPUTDTO s) {
		t.setNombre(s.getNombre());
		t.setEdad(s.getEdad());
	}

	
}
