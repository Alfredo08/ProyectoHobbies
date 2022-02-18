package com.codingdojo.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuarios {
	public static String usuarios[] = { "Alex", "Martha", "Julieta", "Alan", "Antonio" };
	
	@RequestMapping( value="/usuarios", method=RequestMethod.GET)
	public String despliegaUsuarios() {
		
		String respuesta = "";
		for( int i = 0; i < usuarios.length; i ++ ) {
			respuesta += "<div>" +
							usuarios[i] +
						 "</div>";
		}
		
		System.out.println( respuesta );
		
		return respuesta;
	}
	
	@RequestMapping( value="/usuarios/filtrar", method=RequestMethod.GET )
	public String despliegaUsuariosFiltrados( @RequestParam(value="letra") String letra, 
											  @RequestParam(value="id") int id ) {
		String respuesta = "";
		for( int i = 0; i < usuarios.length; i ++ ) {
			
			if( usuarios[i].toLowerCase().charAt(0) == letra.toLowerCase().charAt(0) ) {
				respuesta += "<div>" +
								usuarios[i] +
							"</div>";
			}
		}
		
		
		System.out.println( "Id: " + id );
		System.out.println( respuesta );
		
		return respuesta;
	}
	
	@RequestMapping( value="/usuarios/filtrar/{letra}", method=RequestMethod.GET )
	public String despliegaUsuariosFiltradoPath( @PathVariable("letra") String letra ) {
		String respuesta = "";
		for( int i = 0; i < usuarios.length; i ++ ) {
			
			if( usuarios[i].toLowerCase().charAt(0) == letra.toLowerCase().charAt(0) ) {
				respuesta += "<div>" +
								usuarios[i] +
							"</div>";
			}
		}
		
		System.out.println( respuesta );
		
		return respuesta;
	}
	
}
