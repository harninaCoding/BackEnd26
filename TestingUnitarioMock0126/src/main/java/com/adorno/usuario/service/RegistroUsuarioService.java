package com.adorno.usuario.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adorno.usuario.modelo.Usuario;
import com.adorno.usuario.repository.UsuarioRepository;

@Service
public class RegistroUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegistroUsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(String nombre, String email, String password) {
        // 1. Regla de negocio: No permitir emails duplicados
        if (usuarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        // 2. Lógica de transformación: Encriptar la clave
        String passwordHash = passwordEncoder.encode(password);

        // 3. Persistencia
        Usuario nuevoUsuario = new Usuario(nombre, email, passwordHash);
        return usuarioRepository.save(nuevoUsuario);
    }
}
