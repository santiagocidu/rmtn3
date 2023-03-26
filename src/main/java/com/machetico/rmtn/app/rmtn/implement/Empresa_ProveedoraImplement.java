package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Empresa_proveedora;
import com.machetico.rmtn.app.rmtn.repository.Empresa_ProveedoraRepository;
import com.machetico.rmtn.app.rmtn.service.Empresa_ProveedoraFacade;

@Service
public class Empresa_ProveedoraImplement implements Empresa_ProveedoraFacade {

	@Autowired
	private Empresa_ProveedoraRepository iempresa;

	@Override
	public List<Empresa_proveedora> findALL() {
		return this.iempresa.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Empresa_proveedora findById(Long idempresa_pro) {
		return this.iempresa.getById(idempresa_pro);
	}

	@Override
	public void create(Empresa_proveedora emp) {
		this.iempresa.save(emp);
	}

	@Override
	public void update(Empresa_proveedora emp) {
		this.iempresa.save(emp);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Empresa_proveedora emp) {
		Empresa_proveedora em = this.iempresa.getById(emp.getIdempresa_pro());
		this.iempresa.delete(em);
	}

}
