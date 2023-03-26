package com.machetico.rmtn.app.rmtn.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 11;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;

	@Column(name = "nombre_rol", nullable = false, length = 20)
	private String nombre_rol;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
	private List<Usuario> list_usuario;

	public Rol() {
		super();
	}

	public Rol(Long idRol, String nombre_rol, List<Usuario> list_usuario) {
		super();
		this.idRol = idRol;
		this.nombre_rol = nombre_rol;
		this.list_usuario = list_usuario;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public List<Usuario> getList_usuario() {
		return list_usuario;
	}

	public void setList_usuario(List<Usuario> list_usuario) {
		this.list_usuario = list_usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rol(String nombre_rol) {
		super();
		this.nombre_rol = nombre_rol;
	}
}

