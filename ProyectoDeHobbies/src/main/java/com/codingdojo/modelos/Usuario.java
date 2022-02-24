package com.codingdojo.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "usuarios" )
public class Usuario {
	@Id
	//@GeneratedValue( strategy = GenerationType.IDENTITY )
	private String nombreUsuario;
	
	@NotNull
	@NotEmpty
	private String nombre;
	
	@NotNull
	@NotEmpty
	private String apellido;
	
	@NotNull
	private Long identificador;
	
	@NotNull
	@Size( min = 4, max = 30, message = "El password debe de tener entre 4 y 30 caracteres" )
	private String password;
	
	@OneToMany( mappedBy = "usuario", fetch = FetchType.LAZY )
	private List<Hobby> listaHobbies;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombreUsuario, String nombre, String apellido, Long identificador, String password) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hobby> getListaHobbies() {
		return listaHobbies;
	}

	public void setListaHobbies(List<Hobby> listaHobbies) {
		this.listaHobbies = listaHobbies;
	}
}
