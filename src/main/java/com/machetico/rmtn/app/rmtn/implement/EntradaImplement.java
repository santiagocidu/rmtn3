package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Entrada;
import com.machetico.rmtn.app.rmtn.repository.EntradaRepository;
import com.machetico.rmtn.app.rmtn.service.EntradaFacade;

@Service
public class EntradaImplement implements EntradaFacade {

	@Autowired
	private EntradaRepository ientrada;

	@Override
	public List<Entrada> findALL() {
		return this.ientrada.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Entrada findById(Long identrada) {
		return this.ientrada.getById(identrada);
	}

	@Override
	public void create(Entrada ent) {
		this.ientrada.save(ent);
	}

	@Override
	public void update(Entrada ent) {
		this.ientrada.save(ent);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Entrada ent) {
		Entrada en = this.ientrada.getById(ent.getIdentrada());
		this.ientrada.delete(en);
	}

}
