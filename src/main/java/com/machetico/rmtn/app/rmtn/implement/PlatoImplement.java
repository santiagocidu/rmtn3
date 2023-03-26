package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Entrada;
import com.machetico.rmtn.app.rmtn.model.Plato;
import com.machetico.rmtn.app.rmtn.repository.PlatoRepository;
import com.machetico.rmtn.app.rmtn.service.PlatoFacade;
@Service
public class PlatoImplement implements PlatoFacade {

	@Autowired
	private PlatoRepository platoRepository;

	@Override
	public void save(Plato plato) {
		platoRepository.save(plato);
	}

	@Override
	public List<Plato> listAll() {
		return platoRepository.findAll();
	}

	@Override
	public void deleteById(long id) {
		platoRepository.deleteById(id);
	}

	@Override
	public Plato listById(long id) {
		return platoRepository.findById(id).get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Plato plato) {
		Plato pla = this.platoRepository.getById(plato.getIdplatos());
		this.platoRepository.delete(pla);
	}

	


}
