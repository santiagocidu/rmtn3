package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.InsumoImplement;
import com.machetico.rmtn.app.rmtn.model.Insumo;

@Controller
public class InsumoController {

	@Autowired
	private InsumoImplement insu_imp;

	@GetMapping("/allInsu")
	public String allIns(Model modelo) {
		modelo.addAttribute("insumo", this.insu_imp.findALL());
		return "/insumo/insumo";
	}
	
	@GetMapping("/allInsuEmp")
	public String allInsEmp(Model modelo) {
		modelo.addAttribute("insumo", this.insu_imp.findALL());
		return "/Empleado/insumo";
	}

	@GetMapping("/mapInsu")
	public String mapIns(Model modelo) {
		Insumo ins = new Insumo();
		modelo.addAttribute("ins", ins);
		return "/insumo/insumocreate";
	}

	@GetMapping("/getInsu/{id}")
	public String getIdIns(@PathVariable Long id, Model modelo) {
		Insumo ins = this.insu_imp.findById(id);
		modelo.addAttribute("ins", ins);
		return "/insumo/insumoedit";
	}

	@PostMapping("/saveInsu")
	public String updateIns(@ModelAttribute("ins") Insumo ins) {
		this.insu_imp.update(ins);
		return "redirect:/allInsu";

	}

	@GetMapping("/deleteIns/{id}")
	public String deleteIns(@PathVariable Long id) {
		Insumo insumo = this.insu_imp.findById(id);
		this.insu_imp.delete(insumo);
		return "redirect:/allInsu";
	}
}
