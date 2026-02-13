package com.adorno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Usuario;


//Esta solo se hace para que podamos hacer la prueba con el mock
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	boolean existsByEmail(String email);

	Usuario save(Usuario nuevoUsuario);
	List<Usuario> findByEmailContaining(String dominio);

}
