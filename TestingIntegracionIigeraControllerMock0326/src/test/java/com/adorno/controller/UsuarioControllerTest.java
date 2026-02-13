package com.adorno.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.adorno.modelo.Usuario;
import com.adorno.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
/// Permite usar MockMvc en un test de integración
@AutoConfigureMockMvc(addFilters = false)
//Limpia la base de datos después de cada test para no ensuciar
@Transactional
class UsuarioControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private UsuarioRepository repository;

	@Test
	void test() {
		try {
			List<Body> entrada;
			List<ResultMatcher> especteds=List.of(status().isCreated(),status().ok(),...);
			mockMvc.perform(post("/usuarios/registrar")
//						.with(csrf())
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"nombre\":\"Juan\", \"email\":\"juan@test.com\", \"password\":\"secret123\"}")
						)
					.andExpect(status().isCreated());
			Optional<Usuario> first = repository.findByEmailContaining("juan@test.com").stream().findFirst();
			assertTrue(first.isPresent());
			
			mockMvc.perform(get("/usuarios/user")
						.param("email","juan@test.com"))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
