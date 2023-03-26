package com.machetico.rmtn.app.rmtn.implement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.model.Rol;
import com.machetico.rmtn.app.rmtn.model.Usuario;
import com.machetico.rmtn.app.rmtn.repository.UsuarioRepository;
import com.machetico.rmtn.app.rmtn.service.UsuarioFacade;

@Service
public class UsuarioImplement implements UsuarioFacade {

	@Autowired
	private UsuarioRepository iusuario;

	@Override
	public List<Usuario> findALL() {
		return this.iusuario.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario findById(Long idusuario) {
		return this.iusuario.getById(idusuario);
	}

	@Override
	public void create(Usuario usu) {
		this.iusuario.save(usu);
	}

	@Override
	public void update(Usuario usu) {
		this.iusuario.save(usu);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Usuario usu) {
		Usuario us = this.iusuario.getById(usu.getIdusuario());
		this.iusuario.delete(us);
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre_com(), registroDTO.getCorreo(), (registroDTO.getPassword()),
				Arrays.asList(new Rol("ROLE_USER")));
		return iusuario.save(usuario);

	}
}
