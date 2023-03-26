package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Rol;

public interface RolFacade {

	public List<Rol> findALL();

	public Rol findById(Long idRol);

	public void create(Rol rols);

	public void update(Rol rols);

	public void delete(Rol rols);

}