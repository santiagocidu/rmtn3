package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.implement.RolImplement;
import com.machetico.rmtn.app.rmtn.implement.UsuarioImplement;
import com.machetico.rmtn.app.rmtn.model.Rol;
import com.machetico.rmtn.app.rmtn.model.Usuario;
import com.machetico.rmtn.app.rmtn.service.RolFacade;
import com.machetico.rmtn.app.rmtn.service.UsuarioFacade;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioImplement usu_imp;

	@Autowired
	private RolImplement rol_imp;

	@Autowired
	private UsuarioFacade usuarioFacade;

	@Autowired
	private RolFacade rolFacade;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/usuario")
	public String allUsers(Model modelo) {
		modelo.addAttribute("usuarios", this.usu_imp.findALL());
		return "/usuario/listusuarios";
	}
	
	@GetMapping("/usuarioEmp")
	public String allUsersEmp(Model modelo) {
		modelo.addAttribute("usuarios", this.usu_imp.findALL());
		return "/Empleado/listusuarios";
	}

	@GetMapping("/createUsu")
	public String mapUsers(Model modelo) {
		Usuario us = new Usuario(null, null, null, null, null, null);
		modelo.addAttribute("usu", us);
		modelo.addAttribute("roles", this.rol_imp.findALL());
		return "/usuario/usuariocreate";
	}

	@GetMapping("/getUser/{id}")
	public String getIdUser(@PathVariable Long id, Model modelo) {
		Usuario us = this.usu_imp.findById(id);
		modelo.addAttribute("usu", us);
		modelo.addAttribute("roles", this.rol_imp.findALL());
		return "/usuario/usuarioedit";

	}

	@PostMapping("/createUsu")
	public String registrarCuentaDeUsuario(@ModelAttribute("usu") UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario();
		usuario.setNombre_com(registroDTO.getNombre_com());
		usuario.setCorreo(registroDTO.getCorreo());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		Rol rol = rolFacade.findById((long) 3);
		usuario.setRol(rol);
		usuarioFacade.create(usuario);
		return "redirect:/usuario?exito";
	}

	@PostMapping("/save_user")
	public String updateUser(@ModelAttribute("usu") Usuario usu) {
		Rol rol = this.rol_imp.findById(usu.getRol().getIdRol());
		usu.setRol(rol);
		this.usu_imp.update(usu);
		return "redirect:/usuario";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		Usuario us = this.usu_imp.findById(id);
		this.usu_imp.delete(us);
		return "redirect:/usuario";
	}

}
