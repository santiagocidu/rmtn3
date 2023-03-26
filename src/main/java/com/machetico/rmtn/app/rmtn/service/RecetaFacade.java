package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Receta;


public interface RecetaFacade {
	
	public List<Receta> findALL();

	public Receta findById(Long idreceta);

	public void create(Receta rec);

	public void update(Receta rec);

	public void delete(Receta rec);

}
