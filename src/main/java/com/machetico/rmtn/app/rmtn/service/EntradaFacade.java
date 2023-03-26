package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Entrada;

public interface EntradaFacade {

	public List<Entrada> findALL();

	public Entrada findById(Long identrada);

	public void create(Entrada ent);

	public void update(Entrada ent);

	public void delete(Entrada ent);
}