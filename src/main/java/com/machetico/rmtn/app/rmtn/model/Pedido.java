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


@Entity
@Table(name = "pedidos")

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpedido;

	@Column(name = "telefono", nullable = false, length = 30)
	private String telefono;

	@Column(name = "sugerencia", nullable = true, length = 200)
	private String sugerencia;

	@Column(name = "direccion", nullable = false, length = 11)
	private String direccion;

	@Column(name = "precio_final", nullable = false, length = 30)
	private Integer precio_final;

	@ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkidusuario", referencedColumnName = "idusuario")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<Carrito> list_carrito;

	public Pedido() {
		super();
	} 

	public Pedido(Long idpedido, String telefono, String sugerencia, String direccion, Integer precio_final,
			Usuario usuario, List<Carrito> list_carrito) {
		super();
		this.idpedido = idpedido;
		this.telefono = telefono;
		this.sugerencia = sugerencia;
		this.direccion = direccion;
		this.precio_final = precio_final;
		this.usuario = usuario;
		this.list_carrito = list_carrito;
	}

	public Long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPrecio_final() {
		return precio_final;
	}

	public void setPrecio_final(Integer precio_final) {
		this.precio_final = precio_final;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Carrito> getList_carrito() {
		return list_carrito;
	}

	public void setList_carrito(List<Carrito> list_carrito) {
		this.list_carrito = list_carrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
