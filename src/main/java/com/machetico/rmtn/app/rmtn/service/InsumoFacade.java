package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Insumo;

public interface InsumoFacade {

	public List<Insumo> findALL();

	public Insumo findById(Long idinsumo);

	public void create(Insumo ins);

	public void update(Insumo ins);

	public void delete(Insumo ins);

}