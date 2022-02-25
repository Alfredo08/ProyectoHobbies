package com.codingdojo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Usuario;
import com.codingdojo.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	// private final RepositorioUsuario repositorioUsuario;
	
	//public ServicioUsuario( RepositorioUsuario repositorio ) {
	//	this.repositorioUsuario = repositorio;
	//}
	
	public List<Usuario> selectAllFromUsuarios(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario insertIntoUsuarios( Usuario nuevoUsuario ) {
		return repositorioUsuario.save( nuevoUsuario );
	}
	
	public Long deleteFromUsuarios( String nombreUsuario ) {
		return repositorioUsuario.deleteByNombreUsuario( nombreUsuario );
	}
	
	public Usuario selectFromUsuariosWhereNombreUsuarioAndPassword( String nombreUsuario, String password ) {
		List<Usuario> usuarioEncontrado = repositorioUsuario.findByNombreUsuarioAndPassword(nombreUsuario, password);
		if ( usuarioEncontrado.isEmpty() ) {
			return null;
		}
		else {
			return usuarioEncontrado.get(0);
		}
	}
	
	public Usuario selectFromUsuariosWhereNombreUsuario( String nombreUsuario ) {
		List<Usuario> usuarioEncontrado = repositorioUsuario.findByNombreUsuario( nombreUsuario );
		if ( usuarioEncontrado.isEmpty() ) {
			return null;
		}
		else {
			return usuarioEncontrado.get(0);
		}
	}
	
	public void updateUsuario( Usuario editarUsuario ) {
		repositorioUsuario.actualizaUsuarioOpcion2(editarUsuario.getNombre(), 
										   editarUsuario.getApellido(), 
										   editarUsuario.getPassword(), 
										   editarUsuario.getIdentificador(), 
										   editarUsuario.getNombreUsuario() );
	}
}
