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
@Table(name = "entradas")

public class Entrada implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identrada;

	@Column(name = "fecha_entrada", nullable = false, length = 30)
	private String fecha_entrada;

	@Column(name = "cantidad_entrada", nullable = false, length = 11)
	private Integer cantidad_entrada;

	@ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkidinsumo", referencedColumnName = "idinsumo")
	private Insumo insumo;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "entra_empre", joinColumns = @JoinColumn(name = "fkidentrada", referencedColumnName = "identrada"), inverseJoinColumns = @JoinColumn(name = "fkidempresa_pro", referencedColumnName = "idempresa_pro"))
	private List<Empresa_proveedora> list_empresa_pro;

	public Entrada() {
		super();
	}

	public Entrada(Long identrada, String fecha_entrada, Integer cantidad_entrada, Insumo insumo,
			List<Empresa_proveedora> list_empresa_pro) {
		super();
		this.identrada = identrada;
		this.fecha_entrada = fecha_entrada;
		this.cantidad_entrada = cantidad_entrada;
		this.insumo = insumo;
		this.list_empresa_pro = list_empresa_pro;
	}

	public Long getIdentrada() {
		return identrada;
	}

	public void setIdentrada(Long identrada) {
		this.identrada = identrada;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Integer getCantidad_entrada() {
		return cantidad_entrada;
	}

	public void setCantidad_entrada(Integer cantidad_entrada) {
		this.cantidad_entrada = cantidad_entrada;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public List<Empresa_proveedora> getList_empresa_pro() {
		return list_empresa_pro;
	}

	public void setList_empresa_pro(List<Empresa_proveedora> list_empresa_pro) {
		this.list_empresa_pro = list_empresa_pro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
