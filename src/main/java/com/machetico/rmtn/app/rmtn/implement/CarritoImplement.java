package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Carrito;
import com.machetico.rmtn.app.rmtn.repository.CarritoRepository;
import com.machetico.rmtn.app.rmtn.service.CarritoFacade;

@Service
public class CarritoImplement implements CarritoFacade {

	@Autowired
	private CarritoRepository icarrito;
	
	@Override
	public List<Carrito> findALL() {
		return this.icarrito.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Carrito findById(Long idcarrito) {
		return this.icarrito.getById(idcarrito);
	}

	@Override
	public void create(Carrito car) {
		this.icarrito.save(car);
	}

	@Override
	public void update(Carrito car) {
		this.icarrito.save(car);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Carrito car) {
		Carrito carr = this.icarrito.getById(car.getIdcarrito());
		this.icarrito.delete(carr);
	}

}
