package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.machetico.rmtn.app.rmtn.implement.UsuarioImplement;
import com.machetico.rmtn.app.rmtn.service.EmailService;
import com.machetico.rmtn.app.rmtn.utilities.EmailDetails;

@Controller
public class EmailController{

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioImplement usu_imp;

    @GetMapping("/mapCorreo")
    public String mapCorreo(Model modelo){
        EmailDetails details = new EmailDetails();
        modelo.addAttribute("detalle", details);
        modelo.addAttribute("usuarios", this.usu_imp.findALL());
        return "/Email/EmailSimple";

    }

    @GetMapping("/mapCorreoEmp")
    public String mapCorreoEmp(Model modelo){
        EmailDetails details = new EmailDetails();
        modelo.addAttribute("detalle", details);
        modelo.addAttribute("usuarios", this.usu_imp.findALL());
        return "/Empleado/EmailSimple";

    }
    
    @GetMapping("/mapMailWithAttachment")
    public String mapMailWithAttachment(Model modelo){
        EmailDetails details = new EmailDetails();
        modelo.addAttribute("detalle", details);
        modelo.addAttribute("usuarios", this.usu_imp.findALL());
        return "/Email/EmailCompleto";
    }

    @PostMapping("/sendCorreo")
    public String sendCorreo(@ModelAttribute("details") EmailDetails details){
        this.emailService.sendSimpleMail(details);
        return "redirect:/mapCorreo";
    }

    @PostMapping("/sendCorreoWithAttachment")
    public String sendCorreoWithAttachment(@ModelAttribute("details") EmailDetails details) {
        this.emailService.sendMailWithAttachment(details);
        return "redirect:/mapMailWithAttachment";
    }
    



}