package com.machetico.rmtn.app.rmtn.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.model.Pedido;
import com.machetico.rmtn.app.rmtn.repository.PedidoRepository;
import com.machetico.rmtn.app.rmtn.service.PedidoFacade;

@Service
public class PedidoImplement implements PedidoFacade {

	@Autowired
	private PedidoRepository ipedido;

	@Override
	public List<Pedido> findALL() {
		return this.ipedido.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Pedido findById(Long idpedido) {
		return this.ipedido.getById(idpedido);
	}

	@Override
	public void create(Pedido ped) {
		this.ipedido.save(ped);
	}

	@Override
	public void update(Pedido ped) {
		this.ipedido.save(ped);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Pedido ped) {
		Pedido pe = this.ipedido.getById(ped.getIdpedido());
		this.ipedido.delete(pe);
	}

}
