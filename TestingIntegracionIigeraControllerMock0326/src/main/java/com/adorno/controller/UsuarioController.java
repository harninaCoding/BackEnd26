package com.adorno.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Usuario;
import com.adorno.modelo.UsuarioDTO;
import com.adorno.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    // Inyección por constructor (recomendado)
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody UsuarioDTO datos) {
        // Llamamos al servicio con los datos que llegan del JSON
        Usuario nuevoUsuario = service.registrar(
            datos.nombre(), 
            datos.email(), 
            datos.password()
        );
        
        // Devolvemos un 201 Created y el objeto creado
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
}