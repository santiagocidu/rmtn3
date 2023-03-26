package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.InsumoImplement;
import com.machetico.rmtn.app.rmtn.implement.PlatoImplement;
import com.machetico.rmtn.app.rmtn.implement.RecetaImplement;
import com.machetico.rmtn.app.rmtn.model.Plato;
import com.machetico.rmtn.app.rmtn.model.Receta;

@Controller
public class RecetaController {

	@Autowired
	private RecetaImplement rec_Imp;
	
	@Autowired
	private PlatoImplement pla_imp;
	
	@Autowired
	private InsumoImplement ins_imp;
	
	@GetMapping("/allRec")
	public String allRec(Model modelo) {
		modelo.addAttribute("recetas", this.rec_Imp.findALL());
		return "/Recetas/receta";
	}
	
	@GetMapping("/allRecEmp")
	public String allRecEmp(Model modelo) {
		modelo.addAttribute("recetas", this.rec_Imp.findALL());
		return "/Empleado/receta";
	}
	
	@GetMapping("/mapRec")
	public String mapRec(Model modelo) {
		Receta rec = new Receta();
		modelo.addAttribute("rec", rec);
		modelo.addAttribute("plato", this.pla_imp.listAll());
		modelo.addAttribute("insumo", this.ins_imp.findALL());
		return "/Recetas/recetaCreate";
	}
	
	@GetMapping("/getRece/{id}")
	public String getIdRece(@PathVariable long id, Model modelo) {
		Receta receta = this.rec_Imp.findById(id);
		modelo.addAttribute("recetas", receta);
		modelo.addAttribute("plato", this.pla_imp.listAll());
		modelo.addAttribute("insumo", this.ins_imp.findALL());
		return"/Recetas/recetaEdit";
	}
	
	@PostMapping("/saveRec")
	public String updateRec(@ModelAttribute("rec") Receta rec) {
		Plato pla = this.pla_imp.listById(rec.getPlato().getIdplatos());
		rec.setPlato(pla);
		this.rec_Imp.update(rec);
		return"redirect:/allRec";
	}
	
	@GetMapping("/deleteRec/{id}")
	public String deleteRec(@PathVariable long id) {
		Receta rec = this.rec_Imp.findById(id);
		this.rec_Imp.delete(rec);
		return "redirect:/allRec";
	}
	
}
