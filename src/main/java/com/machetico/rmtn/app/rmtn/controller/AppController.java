package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.machetico.rmtn.app.rmtn.implement.PlatoImplement;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PlatoImplement pla_imp;

	@RequestMapping
	public String goIncio(Model model) {
		try {
			model.addAttribute("listPlatos", pla_imp.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/inicio.html";
	}

	@GetMapping("/Admin")
	public String goAdmin() {
		return "Admin/indexAdmin";
	}

	@GetMapping("/Empleado")
	public String goEmpleado() {
		return "Empleado/indexEmpleado";
	}

	@GetMapping("/Cliente")
	public String goCliente(Model model) {
		try {
			model.addAttribute("listPlatos", pla_imp.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Cliente/indexCliente";
	}

}