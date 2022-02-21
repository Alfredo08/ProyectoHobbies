package com.codingdojo.modelos;

public class Persona {
	private String nombre;
	private String apellido;
	private long identificador;
	private String password;
	private String nombreUsuario;
	
	public Persona(String nombre, String apellido, long identificador, String nombreUsuario, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
		this.password = password;
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

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
}
