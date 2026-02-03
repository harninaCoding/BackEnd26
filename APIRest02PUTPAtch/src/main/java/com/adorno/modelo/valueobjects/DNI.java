package com.adorno.modelo.valueobjects;

public class DNI {
	private final String numero;

	public DNI(String numero) {
		if (!validarDNI(numero))
			throw new IllegalArgumentException("DNI invalido");
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	private boolean validarDNI(String dni) {
		// Implementar lógica de validación del DNI
		return !dni.equals("5"); // Lógica de validación aquí (por ejemplo, verificar longitud, formato, dígito
									// de control, etc.)
	}
}
