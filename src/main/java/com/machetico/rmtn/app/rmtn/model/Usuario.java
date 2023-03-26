package com.machetico.rmtn.app.rmtn.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;

	@Column(name = "nombre_com",  length = 30)
	private String nombre_com;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "correo",  length = 30)
	private String correo;

	@ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkidrol", nullable = true)
	private Rol rol;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Pedido> list_pedido;

	public Usuario() {
		super();
	}

	

	public Usuario(Long idusuario, String nombre_com, String password, String correo, Rol rol,
			List<Pedido> list_pedido) {
		super();
		this.idusuario = idusuario;
		this.nombre_com = nombre_com;
		this.password = password;
		this.correo = correo;
		this.rol = rol;
		this.list_pedido = list_pedido;
	}
	

	public Usuario(String nombre_com, String password, String correo, Rol rol, List<Pedido> list_pedido) {
		super();
		this.nombre_com = nombre_com;
		this.password = password;
		this.correo= correo;
		this.rol = rol;
		this.list_pedido = list_pedido;
	}
	

	public Usuario(String string, String string2, String string3, List<Rol> list) {
		super();
	}



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

	public List<Pedido> getList_pedido() {
		return list_pedido;
	}

	public void setList_pedido(List<Pedido> list_pedido) {
		this.list_pedido = list_pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
