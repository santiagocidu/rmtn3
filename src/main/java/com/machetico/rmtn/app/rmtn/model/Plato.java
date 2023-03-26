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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "platos")
public class Plato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idplatos;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;

	@Column(name = "precio", nullable = false, length = 30)
	private Integer precio;

	@Column(name = "image")
	private String image;

	@OneToOne(mappedBy = "plato")
	private Receta receta;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "list_pla")
	private List<Carrito> list_carrito;

	public Plato() {
		super();
	}

	public Plato(Long idplatos, String nombre, String descripcion, Integer precio, String image, Receta receta,
			List<Carrito> list_carrito) {
		super();
		this.idplatos = idplatos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.image = image;
		this.receta = receta;
		this.list_carrito = list_carrito;
	}

	public Long getIdplatos() {
		return idplatos;
	}

	public void setIdplatos(Long idplatos) {
		this.idplatos = idplatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
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
