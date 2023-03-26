package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Plato;

public interface PlatoFacade {

	void save(Plato plato);

	List<Plato> listAll();

	void deleteById(long id);

	Plato listById(long id);
	
	public void delete(Plato plato);

}
