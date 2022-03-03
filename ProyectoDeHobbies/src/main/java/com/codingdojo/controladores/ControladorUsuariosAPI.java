package com.codingdojo.controladores;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.modelos.Usuario;
import com.codingdojo.servicios.ServicioUsuario;

@RestController
@RequestMapping( "/api" )
public class ControladorUsuariosAPI {
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping( value = "/usuarios", method = RequestMethod.GET )
	public List<Usuario> apiObtenerUsuarios(){
		return servicioUsuario.selectAllFromUsuarios();
	}
	
	@RequestMapping( value = "/usuarios2", method = RequestMethod.GET )
	public ResponseEntity<List<Usuario>> apiObtenerUsuarios2(){
		List<Usuario> usuarios = servicioUsuario.selectAllFromUsuarios();
		return new ResponseEntity<>( usuarios, HttpStatus.ACCEPTED );
	}
	
	@RequestMapping( value = "/usuarios3", method = RequestMethod.GET )
	public ResponseEntity<List<Object []>> apiObtenerUsuarios3(){
		List<Object []> usuarios = servicioUsuario.selectFromUsuariosHobbies();
		return new ResponseEntity<>( usuarios, HttpStatus.ACCEPTED );
	}
	
	@RequestMapping( value = "/usuario/nuevo", method = RequestMethod.POST )
	public ResponseEntity<Usuario> apiAgregarUsuario( @RequestBody Usuario nuevoUsuario ){
		System.out.println( nuevoUsuario.getNombre() );
		System.out.println( nuevoUsuario.getApellido() );
		System.out.println( nuevoUsuario.getIdentificador() );
		System.out.println( nuevoUsuario.getPassword() );
		System.out.println( nuevoUsuario.getNombreUsuario() );
		
		String hash = BCrypt.hashpw( nuevoUsuario.getPassword(), BCrypt.gensalt() );
		nuevoUsuario.setPassword( hash );
		// Por hacer, validaciones antes de enviar a la base de datos!!!
		Usuario usuarioCreado = servicioUsuario.insertIntoUsuarios( nuevoUsuario );
		
		return new ResponseEntity<>( usuarioCreado, HttpStatus.CREATED );
		
	}
	
}
