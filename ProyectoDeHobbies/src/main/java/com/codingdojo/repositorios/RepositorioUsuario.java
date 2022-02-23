package com.codingdojo.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
	// SELECT * FROM usuarios
	List<Usuario> findAll();
	
	// INSERT INTO usuarios(nombre_usuario, nombre, apellido, identificador, password)
	// VALUES( Objecto con todos los datos )
	@SuppressWarnings("unchecked")
	Usuario save( Usuario nuevoUsuario );
	
	// DELTE FROM usuarios WHERE nombre_usuario = nombreUsuario
	@Transactional
	Long deleteByNombreUsuario( String nombreUsuario );
	
	List<Usuario> findByNombreUsuarioAndPassword( String nombreUsuario, String password );
}
