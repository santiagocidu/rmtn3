package com.machetico.rmtn.app.rmtn.service;

import java.util.List;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.model.Usuario;

public interface UsuarioFacade {

	public List<Usuario> findALL();

	public Usuario findById(Long idusuario);

	public void create(Usuario usu);

	public void update(Usuario usu);

	public void delete(Usuario usu);
	
	public Usuario guardar(UsuarioRegistroDTO registroDTO);

}
