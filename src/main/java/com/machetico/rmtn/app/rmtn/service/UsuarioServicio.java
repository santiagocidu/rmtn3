package com.machetico.rmtn.app.rmtn.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.model.Usuario;

public interface UsuarioServicio extends UserDetailsService {
	
	public Usuario guardar(UsuarioRegistroDTO registroDTO);

}
