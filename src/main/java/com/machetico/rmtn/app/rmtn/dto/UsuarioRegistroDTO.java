package com.machetico.rmtn.app.rmtn.dto;

import com.machetico.rmtn.app.rmtn.model.Rol;

public class UsuarioRegistroDTO {

	private Long idusuario;
	private String nombre_com;
	private String password;
	private String correo;
	private Rol rol;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre_com() {
		return nombre_com;
	}

	public void setNombre_com(String nombre_com) {
		this.nombre_com = nombre_com;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public UsuarioRegistroDTO(Long idusuario, String nombre_com, String password, String correo, Rol rol) {
		super();
		this.idusuario = idusuario;
		this.nombre_com = nombre_com;
		this.password = password;
		this.correo = correo;
		this.rol = rol;
	}

	public UsuarioRegistroDTO(String nombre_com, String password, String correo, Rol rol) {
		super();
		this.nombre_com = nombre_com;
		this.password = password;
		this.correo = correo;
		this.rol = rol;
	}

	public UsuarioRegistroDTO(String correo) {
		super();
		this.correo = correo;
	}

	public UsuarioRegistroDTO() {
		super();
	}

}
