package com.codingdojo.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.modelos.Usuario;
import com.codingdojo.servicios.ServicioUsuario;

@Controller
@RequestMapping( "/usuarios" )
public class ControladorUsuario {
	
	private final ServicioUsuario servicioUsuario;
	
	public ControladorUsuario( ServicioUsuario servicio ) {
		this.servicioUsuario = servicio;
	}
	
	@RequestMapping( value = "", method = RequestMethod.GET )
	public String despliegaUsuarios( Model model ) {
		List<Usuario> listaUsuarios = servicioUsuario.selectAllFromUsuarios();
		model.addAttribute( "listaUsuarios", listaUsuarios );
		return "usuarios.jsp";
	}
	
	@RequestMapping( value = "/registro", method = RequestMethod.GET )
	public String despliegaRegistro( @ModelAttribute("usuario") Usuario nuevoUsuario ) {
		return "registro.jsp";
	}
	
	@RequestMapping( value = "/registrar", method = RequestMethod.POST )
	public String registrarUsuario( @Valid @ModelAttribute("usuario") Usuario nuevoUsuario, BindingResult result ) {
		
		if ( result.hasErrors() ) {
			return "registro.jsp";
		}
		else {
			servicioUsuario.insertIntoUsuarios( nuevoUsuario );
		
			return "redirect:/usuarios";
		}
	}
	
	@RequestMapping( value = "/eliminar/{nombreUsuario}", method = RequestMethod.DELETE )
	public String eliminarUsuario( @PathVariable("nombreUsuario") String nombreUsuario ) {
		servicioUsuario.deleteFromUsuarios( nombreUsuario );
		return "redirect:/usuarios";
	}
}
