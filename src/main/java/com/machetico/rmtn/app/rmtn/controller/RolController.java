package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.RolImplement;
import com.machetico.rmtn.app.rmtn.model.Rol;

@Controller
public class RolController {

	@Autowired
	private RolImplement rol_imp;

	@GetMapping("/allRol")
	public String allRol(Model modelo) {
		modelo.addAttribute("roles", this.rol_imp.findALL());
		return "/rol/listrol";
	}

	@GetMapping("/mapRol")
	public String mapRol(Model modelo) {
		Rol ro = new Rol();
		modelo.addAttribute("roles", ro);
		return "/rol/rolcreate";
	}

	@GetMapping("/getRol/{id}")
	public String getIdRol(@PathVariable Long id, Model modelo) {
		Rol ro = this.rol_imp.findById(id);
		modelo.addAttribute("roles", ro);
		return "/rol/roledit";
	}

	@PostMapping("/saveRol")
	public String updateRol(@ModelAttribute("roles") Rol ro) {
		this.rol_imp.update(ro);
		return "redirect:/allRol";
	}

	@GetMapping("/deleteRol/{id}")
	public String deleteRol(@PathVariable Long id) {
		Rol ro = this.rol_imp.findById(id);
		this.rol_imp.delete(ro);
		return "redirect:/allRol";
	}

}
