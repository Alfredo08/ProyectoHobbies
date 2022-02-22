package com.codingdojo.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
}
