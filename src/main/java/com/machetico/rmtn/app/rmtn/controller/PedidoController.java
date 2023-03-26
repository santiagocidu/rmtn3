package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.UsuarioImplement;
import com.machetico.rmtn.app.rmtn.implement.PedidoImplement;
import com.machetico.rmtn.app.rmtn.model.Pedido;
import com.machetico.rmtn.app.rmtn.model.Usuario;

@Controller
public class PedidoController {

    @Autowired
    private PedidoImplement ped_imp;

    @Autowired
    private UsuarioImplement usu_imp;

    @GetMapping("/allPedi")
    public String allPed(Model modelo) {
        modelo.addAttribute("pedido", this.ped_imp.findALL());
        modelo.addAttribute("usu", this.usu_imp.findALL());
        return "/pedido/pedido";
    }

    @GetMapping("/allPediEmp")
    public String allPedEmp(Model modelo) {
        modelo.addAttribute("pedido", this.ped_imp.findALL());
        modelo.addAttribute("usu", this.usu_imp.findALL());
        return "/Empleado/pedido";
    }
    
    @GetMapping("/mapPedi")
    public String mapPed(Model modelo) {
        Pedido ped = new Pedido();
        modelo.addAttribute("ped", ped);
        modelo.addAttribute("usua", this.usu_imp.findALL());
        return "/pedido/pedidocreate";
    }

    @GetMapping("/getPedi/{id}")
    public String getIdPed(@PathVariable Long id, Model modelo) {
        Pedido ped = this.ped_imp.findById(id);
        modelo.addAttribute("ped", ped);
        modelo.addAttribute("usua", this.usu_imp.findALL());
        return "/pedido/pedidoedit";
    }

    @PostMapping("/savePedi")
    public String updatePed(@ModelAttribute("ped") Pedido ped) {
        this.ped_imp.update(ped);
        Usuario usu = this.usu_imp.findById(ped.getUsuario().getIdusuario());
        ped.setUsuario(usu);
        return "redirect:/allPedi";

    }

    @GetMapping("/deletePed/{id}")
    public String deletePed(@PathVariable Long id) {
        Pedido pedido = this.ped_imp.findById(id);
        this.ped_imp.delete(pedido);
        return "redirect:/allPedi";
    }
}
