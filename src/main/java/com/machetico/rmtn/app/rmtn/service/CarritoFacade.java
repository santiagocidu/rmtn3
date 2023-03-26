package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Carrito;

public interface CarritoFacade {

	public List<Carrito> findALL();

	public Carrito findById(Long idcarrito);

	public void create(Carrito car);

	public void update(Carrito car);

	public void delete(Carrito car);

}

	
