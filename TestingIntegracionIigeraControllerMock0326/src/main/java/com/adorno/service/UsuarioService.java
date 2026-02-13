package com.adorno.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Usuario;
import com.adorno.repository.UsuarioRepository;

@Service
public class UsuarioService {

	    private final UsuarioRepository repository;
	    private final PasswordEncoder passwordEncoder;

	    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
	        this.repository = repository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    public Usuario registrar(String nombre, String email, String password) {
	        // 1. EL CAMINO TRISTE: Validar si el email ya existe
	        if (repository.existsByEmail(email)) {
	            throw new RuntimeException("El email ya está registrado");
	        }

	        // 2. Lógica de negocio: Encriptar la contraseña
	        String passwordHasheada = passwordEncoder.encode(password);

	        // 3. Crear la entidad
	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setNombre(nombre);
	        nuevoUsuario.setEmail(email);
	        nuevoUsuario.setPassword(passwordHasheada);

	        // 4. Guardar y retornar
	        return repository.save(nuevoUsuario);
	    }

}
