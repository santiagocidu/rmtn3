package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.Empresa_ProveedoraImplement;
import com.machetico.rmtn.app.rmtn.model.Empresa_proveedora;
import com.machetico.rmtn.app.rmtn.repository.EntradaRepository;

@Controller
public class Empresa_proveedoraController{

    @Autowired
    private Empresa_ProveedoraImplement empre_imp;
    
    @Autowired
    private EntradaRepository ent_imp;

    @GetMapping("/allEmpre")
    public String allEmpres(Model modelo) {
        modelo.addAttribute("Empresa_Proveedora", this.empre_imp.findALL());
        return "/Empresa_Proveedora/empresa_proveedora";
    }
    
    @GetMapping("/allEmpreEmp")
    public String allEmpresEmp(Model modelo) {
        modelo.addAttribute("Empresa_Proveedora", this.empre_imp.findALL());
        return "/Empleado/empresa_proveedora";
    }

    @GetMapping("/mapEmpre")
    public String mapEmpres(Model modelo) {
        Empresa_proveedora empp = new Empresa_proveedora();
        modelo.addAttribute("empp", empp);
        modelo.addAttribute("lista_entradas", this.ent_imp.findAll());
        return "/Empresa_Proveedora/empresa_proveedoracreate";
    }

    @GetMapping("/getEmpre/{id}")
    public String getIdEmpres(@PathVariable Long id, Model modelo) {
        Empresa_proveedora empp = this.empre_imp.findById(id);
        modelo.addAttribute("empp", empp);
        modelo.addAttribute("lista_entradas", this.ent_imp.findAll());
        return "/Empresa_Proveedora/empresa_proveedoraedit";
    }

    @PostMapping("/saveEmpre")
    public String updateIns(@ModelAttribute("empp") Empresa_proveedora empp) {
        this.empre_imp.update(empp);
        return "redirect:/allEmpre";

    }

    @GetMapping("/deleteemp/{id}")
    public String deletePer(@PathVariable Long id) {
        Empresa_proveedora empresa_proveedora = this.empre_imp.findById(id);
        this.empre_imp.delete(empresa_proveedora);
        return "redirect:/allEmpre";
    }
}
    
