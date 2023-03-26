package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Receta;
import com.machetico.rmtn.app.rmtn.repository.RecetaRepository;
import com.machetico.rmtn.app.rmtn.service.RecetaFacade;

@Service
public class RecetaImplement implements RecetaFacade {

	@Autowired
	private RecetaRepository ireceta;

	@Override
	public List<Receta> findALL() {
		return this.ireceta.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Receta findById(Long idreceta) {
		return this.ireceta.getById(idreceta);
	}

	@Override
	public void create(Receta rec) {
		this.ireceta.save(rec);
	}

	@Override
	public void update(Receta rec) {
		this.ireceta.save(rec);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Receta rec) {
		Receta re = this.ireceta.getById(rec.getIdreceta());
		this.ireceta.delete(re);
	}

}
