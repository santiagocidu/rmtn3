package com.machetico.rmtn.app.rmtn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.model.Rol;
import com.machetico.rmtn.app.rmtn.model.Usuario;
import com.machetico.rmtn.app.rmtn.service.RolFacade;
import com.machetico.rmtn.app.rmtn.service.UsuarioFacade;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioFacade usuarioFacade;

	@Autowired
	private RolFacade rolFacade;

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}

	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario();
		usuario.setNombre_com(registroDTO.getNombre_com());
		usuario.setCorreo(registroDTO.getCorreo());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		Rol rol = rolFacade.findById((long) 2);
		usuario.setRol(rol);
		usuarioFacade.create(usuario);
		return "redirect:/registro?exito";
	}

}
