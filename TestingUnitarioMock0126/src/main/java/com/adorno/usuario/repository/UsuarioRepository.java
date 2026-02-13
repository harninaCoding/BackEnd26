package com.adorno.usuario.repository;

import com.adorno.usuario.modelo.Usuario;


//Esta solo se hace para que podamos hacer la prueba con el mock
public interface UsuarioRepository {

	boolean existsByEmail(String email);

	Usuario save(Usuario nuevoUsuario);

}
