package com.codingdojo.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "hobbies" )
public class Hobby {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	private String nombre;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "nombreUsuario" )
	private Usuario usuario;
	
	public Hobby() {
		
	}
	
	public Hobby( long id, String nombre, Usuario usuario ) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
