package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.model.Pedido;

public interface PedidoFacade {

	public List<Pedido> findALL();

	public Pedido findById(Long idpedido);

	public void create(Pedido ped);

	public void update(Pedido ped);

	public void delete(Pedido ped);

}