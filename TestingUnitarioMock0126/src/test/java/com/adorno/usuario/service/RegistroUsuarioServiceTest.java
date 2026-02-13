package com.adorno.usuario.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.adorno.usuario.modelo.Usuario;
import com.adorno.usuario.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class RegistroUsuarioServiceTest {

	// Mock significa que no se va a usar la clase real, sino una simulada,
	// que se comporta como la real pero no hace nada realmente
	// (no accede a la base de datos, no hace hashing, etc) en nuestro caso va a ser
	// inyectada en service
	@Mock
	private UsuarioRepository usuarioRepository;
	@Mock
	private BCryptPasswordEncoder passwordEncoder;

	// InjectMocks significa que se va a crear una instancia real de
	// RegistroUsuarioService,
	// pero con los mocks inyectados en lugar de las dependencias reales
	// esta instancia la crea Mockito, no Spring, por eso no usamos @Autowired
	@InjectMocks
	private RegistroUsuarioService service;

	// Para ejecutar el test, usamos el metodo "registrar" de service, que es el que
	// queremos probar no necesitamos Spring ni arrancar el contexto de Spring.
	@Test
	void test(UsuarioRepository usuarioRepository) {
		Mockito.when(usuarioRepository.existsByEmail("pepe@test.com")).thenReturn(false);
		Mockito.when(passwordEncoder.encode("1234")).thenReturn("no lo se");
		String password = "hash123";
		Usuario usuarioParaGuardar = new Usuario("Pepe", "pepe@test.com", password);
		// Simulamos que el "save" devuelve el objeto con ID (como haría la lista)
		usuarioParaGuardar.setId(1L);
		Mockito.when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioParaGuardar);
		 // Ejecutamos
        Usuario resultado = service.registrar("Pepe", "pepe@test.com", "1234");
        //verificacion
        assertNotNull(resultado.getId());
        assertEquals(password, resultado.getPassword());
	}

}
