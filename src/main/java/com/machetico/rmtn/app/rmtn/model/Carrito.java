
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "carrito")

public class Carrito implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcarrito;
	
	@Column(name = "cantidad", nullable = false, length = 11)
	private Integer cantidad;

	@Column(name = "precio_unitario", nullable = false, length = 11)
	private Integer precio;

	@Column(name = "subtotal", nullable = false, length = 11)
	private Integer subtotal;


	@ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkidpedido", referencedColumnName = "idpedido")
	private Pedido pedido;

	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "carr_pla", joinColumns = @JoinColumn(name = "fkidcarrito", referencedColumnName = "idcarrito"), inverseJoinColumns = @JoinColumn(name = "fkidplatos", referencedColumnName = "idplatos"))
	private List<Plato> list_pla;
	

	public Carrito() {
		super();
	}


	public Carrito(Long idcarrito, Integer cantidad, Integer precio, Integer subtotal, Pedido pedido,
			List<Plato> list_pla) {
		super();
		this.idcarrito = idcarrito;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
		this.pedido = pedido;
		this.list_pla = list_pla;
	}


	public Long getIdcarrito() {
		return idcarrito;
	}


	public void setIdcarrito(Long idcarrito) {
		this.idcarrito = idcarrito;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public Integer getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public List<Plato> getList_pla() {
		return list_pla;
	}


	public void setList_pla(List<Plato> list_pla) {
		this.list_pla = list_pla;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}