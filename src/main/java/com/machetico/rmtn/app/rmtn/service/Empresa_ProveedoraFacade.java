package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Empresa_proveedora;

public interface Empresa_ProveedoraFacade {

	public List<Empresa_proveedora> findALL();

	public Empresa_proveedora findById(Long idempresa_pro);

	public void create(Empresa_proveedora emp);

	public void update(Empresa_proveedora emp);

	public void delete(Empresa_proveedora emp);

}
