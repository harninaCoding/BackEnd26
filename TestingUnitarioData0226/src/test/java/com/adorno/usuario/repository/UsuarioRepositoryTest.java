package com.adorno.usuario.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.adorno.usuario.modelo.Usuario;

@DataJpaTest
/*
 * Que hace esta anotacion: 1. Configura una base de datos en memoria (H2)
 * automáticamente.
 * 
 * 2. Escanea solo las entidades @Entity y los repositorios.
 * 
 * 3. Al finalizar cada test, hace rollback, por lo que la base de datos siempre
 * empieza limpia. No hace falta que configureis aplication.properties si usais
 * h2 si necesitas configurarlo si usas otra base de datos en memoria o una base
 * de datos real
 */
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private TestEntityManager entityManager; // Para meter datos de prueba

	@Test
	void test() {
		Usuario u1 = new Usuario("Pepe", "pepe@gmail.com", "1234");
		Usuario u2 = new Usuario("Ana", "ana@hotmail.com", "1234");
		entityManager.persist(u1);
		entityManager.persist(u2);
		entityManager.flush();
		// WHEN: Ejecutamos tu consulta personalizada
		List<Usuario> resultados = repository.findByEmailContaining("gmail.com");
		// THEN: Verificamos los resultados
		assertEquals(1, resultados.size());
		assertEquals("pepe@gmail.com", resultados.get(0).getEmail());
		System.out.println("termina el test");
	}

}
