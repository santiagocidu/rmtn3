package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.EntradaImplement;
import com.machetico.rmtn.app.rmtn.implement.InsumoImplement;
import com.machetico.rmtn.app.rmtn.model.Entrada;
import com.machetico.rmtn.app.rmtn.model.Insumo;
import com.machetico.rmtn.app.rmtn.repository.Empresa_ProveedoraRepository;

@Controller
public class EntradaController {

	@Autowired
	private EntradaImplement ent_imp;

	@Autowired
	private InsumoImplement ins_imp;

	@Autowired
	private Empresa_ProveedoraRepository emp_imp;

	@GetMapping("/allEnt")
	public String allEnt(Model modelo) {
		modelo.addAttribute("entradas", this.ent_imp.findALL());
		return "/Entrada/entrada";
	}
	
	@GetMapping("/allEntEmp")
	public String allEntEmp(Model modelo) {
		modelo.addAttribute("entradas", this.ent_imp.findALL());
		return "/Empleado/entrada";
	}

	@GetMapping("/mapEnt")
	public String mapEnt(Model modelo) {
		Entrada ent = new Entrada();
		modelo.addAttribute("ent", ent);
		modelo.addAttribute("insumo", this.ins_imp.findALL());
		modelo.addAttribute("list_empresas", this.emp_imp.findAll());
		return "/Entrada/entradacreate";

	}

	@GetMapping("/getEntra/{id}")
	public String getIdEntra(@PathVariable Long id, Model modelo) {
		Entrada entrada = this.ent_imp.findById(id);
		modelo.addAttribute("entradas", entrada);
		modelo.addAttribute("insumo", this.ins_imp.findALL());
		modelo.addAttribute("list_empresas", this.emp_imp.findAll());
		return "/Entrada/entradaedit";
	}

	@PostMapping("/saveEnt")
	public String updateEnt(@ModelAttribute("ent") Entrada ent) {
		Insumo ins = this.ins_imp.findById(ent.getInsumo().getIdinsumo());
		ent.setInsumo(ins);
		this.ent_imp.update(ent);
		return "redirect:/allEnt";
	}

	@GetMapping("/deleteEnt/{id}")
	public String deleteEnt(@PathVariable Long id) {
		Entrada ent = this.ent_imp.findById(id);
		this.ent_imp.delete(ent);
		return "redirect:/allEnt";
	}
}