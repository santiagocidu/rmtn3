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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idreceta;
	
	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion_detallada;
	
	@Column(name = "cantidad_actual", nullable = false, length = 11)
	private Integer cantidad_actual;
	
	@OneToOne
	@JoinColumn(name = "fkidplato", referencedColumnName = "idplatos")
	private Plato plato; 

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "rece_ins", joinColumns = @JoinColumn(name = "fkidreceta", referencedColumnName = "idreceta"), inverseJoinColumns = @JoinColumn(name = "fkidinsumo", referencedColumnName = "idinsumo"))
	private List<Insumo> list_ins;

	public Receta() {
		super();
	}

	public Receta(Long idreceta, String descripcion_detallada, Integer cantidad_actual, Plato plato,
			List<Insumo> list_ins) {
		super();
		this.idreceta = idreceta;
		this.descripcion_detallada = descripcion_detallada;
		this.cantidad_actual = cantidad_actual;
		this.plato = plato;
		this.list_ins = list_ins;
	}

	public Long getIdreceta() {
		return idreceta;
	}

	public void setIdreceta(Long idreceta) {
		this.idreceta = idreceta;
	}

	public String getDescripcion_detallada() {
		return descripcion_detallada;
	}

	public void setDescripcion_detallada(String descripcion_detallada) {
		this.descripcion_detallada = descripcion_detallada;
	}

	public Integer getCantidad_actual() {
		return cantidad_actual;
	}

	public void setCantidad_actual(Integer cantidad_actual) {
		this.cantidad_actual = cantidad_actual;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public List<Insumo> getList_ins() {
		return list_ins;
	}

	public void setList_ins(List<Insumo> list_ins) {
		this.list_ins = list_ins;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
