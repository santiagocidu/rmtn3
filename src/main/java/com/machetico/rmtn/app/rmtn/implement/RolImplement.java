package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Rol;
import com.machetico.rmtn.app.rmtn.repository.RolRepository;
import com.machetico.rmtn.app.rmtn.service.RolFacade;

@Service
public class RolImplement implements RolFacade {

	@Autowired
	private RolRepository irol;

	@Override
	public List<Rol> findALL() {
		return this.irol.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Rol findById(Long idRol) {
		return this.irol.getById(idRol);
	}

	@Override
	public void create(Rol rols) {
		this.irol.save(rols);
	}

	@Override
	public void update(Rol rols) {
		this.irol.save(rols);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Rol rols) {
		Rol ro = this.irol.getById(rols.getIdRol());
		this.irol.delete(ro);
	}

}
