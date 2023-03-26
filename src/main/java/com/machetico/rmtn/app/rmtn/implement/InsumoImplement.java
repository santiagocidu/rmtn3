package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Insumo;
import com.machetico.rmtn.app.rmtn.repository.InsumoRepository;
import com.machetico.rmtn.app.rmtn.service.InsumoFacade;

@Service
public class InsumoImplement implements InsumoFacade {

	@Autowired
	private InsumoRepository iinsumo;

	@Override
	public List<Insumo> findALL() {
		return this.iinsumo.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Insumo findById(Long idinsumo) {
		return this.iinsumo.getById(idinsumo);
	}

	@Override
	public void create(Insumo ins) {
		this.iinsumo.save(ins);
	}

	@Override
	public void update(Insumo ins) {
		this.iinsumo.save(ins);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Insumo ins) {
		Insumo in = this.iinsumo.getById(ins.getIdinsumo());
		this.iinsumo.delete(in);
	}

}
