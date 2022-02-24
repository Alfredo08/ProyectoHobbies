package com.codingdojo.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	
	@Transactional
	@Modifying
	@Query( value = "UPDATE usuarios " +
					"SET nombre = ?1, apellido = ?2, password = ?3, identificador = ?4 " +
					"WHERE nombre_usuario = ?5", nativeQuery = true )
	void actualizaUsuario( String nombre, String apellido, String password, Long identificador, String nombreUsuario); 
	
	@Transactional
	@Modifying
	@Query( value = "UPDATE usuarios " +
					"SET nombre = :nombre, apellido = :apellido, password = :password, identificador = :identificador " +
					"WHERE nombre_usuario = :nombreUsuario", nativeQuery = true )
	void actualizaUsuarioOpcion2( @Param("nombre") String nombre, @Param("apellido") String apellido, 
								  @Param("password") String password, @Param("identificador")Long identificador, 
								  @Param("nombreUsuario") String nombreUsuario); 
	
}
