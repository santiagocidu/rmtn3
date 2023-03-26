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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "insumos")

public class Insumo implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinsumo;

	@Column(name = "nombre_insumo", nullable = false, length = 30)
	private String nombre_insumo;

	@Column(name = "cantidad_actual", nullable = false, length = 11)
	private Integer cantidad_actual;
	
	@Column(name = "unidad_medida", nullable = false, length = 30)
	private String unidad_medida;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "list_ins")
	private List<Receta> list_receta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo")
	private List<Entrada> list_entrada;
	
	public Insumo() {
		super();
	}

	public Insumo(Long idinsumo, String nombre_insumo, Integer cantidad_actual, String unidad_medida,
			List<Receta> list_receta, List<Entrada> list_entrada) {
		super();
		this.idinsumo = idinsumo;
		this.nombre_insumo = nombre_insumo;
		this.cantidad_actual = cantidad_actual;
		this.unidad_medida = unidad_medida;
		this.list_receta = list_receta;
		this.list_entrada = list_entrada;
	}

	public Long getIdinsumo() {
		return idinsumo;
	}

	public void setIdinsumo(Long idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getNombre_insumo() {
		return nombre_insumo;
	}

	public void setNombre_insumo(String nombre_insumo) {
		this.nombre_insumo = nombre_insumo;
	}

	public Integer getCantidad_actual() {
		return cantidad_actual;
	}

	public void setCantidad_actual(Integer cantidad_actual) {
		this.cantidad_actual = cantidad_actual;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public List<Receta> getList_receta() {
		return list_receta;
	}

	public void setList_receta(List<Receta> list_receta) {
		this.list_receta = list_receta;
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
