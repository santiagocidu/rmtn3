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

import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "empresa_provedora")

public class Empresa_proveedora implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempresa_pro;

	@Column(name = "nombre_empresa", nullable = false, length = 30)
	private String nombre_empresa;

	@Column(name = "direccion_empresa", nullable = false, length = 30)
	private String direccion_empresa;

	@Column(name = "telefono_empresa", nullable = false, length = 15)
	private String telefono_empresa;

	@Column(name = "correo_empresa", nullable = false, length = 40)
	private String correo_empresa;


	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "list_empresa_pro")
	private List<Entrada> list_entrada;

	public Empresa_proveedora() {
		super();
	}

	public Empresa_proveedora(Long idempresa_pro, String nombre_empresa, String direccion_empresa,
			String telefono_empresa, String correo_empresa, List<Entrada> list_entrada) {
		super();
		this.idempresa_pro = idempresa_pro;
		this.nombre_empresa = nombre_empresa;
		this.direccion_empresa = direccion_empresa;
		this.telefono_empresa = telefono_empresa;
		this.correo_empresa = correo_empresa;
		this.list_entrada = list_entrada;
	}

	public Long getIdempresa_pro() {
		return idempresa_pro;
	}

	public void setIdempresa_pro(Long idempresa_pro) {
		this.idempresa_pro = idempresa_pro;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getDireccion_empresa() {
		return direccion_empresa;
	}

	public void setDireccion_empresa(String direccion_empresa) {
		this.direccion_empresa = direccion_empresa;
	}

	public String getTelefono_empresa() {
		return telefono_empresa;
	}

	public void setTelefono_empresa(String telefono_empresa) {
		this.telefono_empresa = telefono_empresa;
	}

	public String getCorreo_empresa() {
		return correo_empresa;
	}

	public void  setCorreo_empresa(String correo_empresa) {
		this.correo_empresa = correo_empresa;
	}

	public List<Entrada> getList_entrada() {
		return list_entrada;
	}

	public void setList_entrada(List<Entrada> list_entrada) {
		this.list_entrada = list_entrada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
