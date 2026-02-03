package com.adorno.modelo.mappers;

public class NombreSimplePersonaVerifier implements Verifier<String> {

	@Override
	public boolean verify(String t) {
		String[] split = t.split(" ");
		return split.length>1;
	}

}
