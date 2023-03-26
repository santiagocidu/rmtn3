package com.machetico.rmtn.app.rmtn.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.machetico.rmtn.app.rmtn.implement.PlatoImplement;
import com.machetico.rmtn.app.rmtn.model.Plato;
import com.machetico.rmtn.app.rmtn.service.IUploadFileService;

@Controller
public class PlatoController {

	@Autowired
	private PlatoImplement pla_imp;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping("/listPlatos")
	public String listPlatos(Model model) {
		try {
			model.addAttribute("listPlatos", pla_imp.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Platos/plato";
	}
	
	@GetMapping("/listPlatosEmp")
	public String listPlatosEmp(Model model) {
		try {
			model.addAttribute("listPlatos", pla_imp.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Empleado/plato";
	}

	@GetMapping(value = "/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename) {
		Resource resource = null;
		try {
			resource = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/newPlato")
	public String newPlato(Model model) {
		model.addAttribute("plato", new Plato());
		model.addAttribute("listPlatos", pla_imp.listAll());
		return "Platos/platoCreate";
	}

	@PostMapping("/savePlato")
	public String savePlato(@Validated @ModelAttribute("plato") Plato plato, BindingResult result, Model model,
			@RequestParam("file") MultipartFile image, RedirectAttributes flash, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			return "Platos/platoCreate";
		} else {
			if (!image.isEmpty()) {
				if (plato.getIdplatos() > 0 && plato.getImage() != null && plato.getImage().length() > 0) {
					uploadFileService.delete(plato.getImage());
				}
				String uniqueFileName = uploadFileService.copy(image);
				plato.setImage(uniqueFileName);
			}
			pla_imp.save(plato);
			status.setComplete();
		}
		return "redirect:/listPlatos";
	}

	@RequestMapping("/updatePlato/{id}")
	public String goUpdate(@PathVariable(value = "id") long id, Model model) {
		Plato plato = pla_imp.listById(id);
		model.addAttribute("plato", plato);
		return "Platos/platoEdit";
	}

	@RequestMapping("/detailPlato/{id}")
	public String goDetail(@PathVariable(value = "id") long id, Model model) {
		Plato plato = pla_imp.listById(id);
		model.addAttribute("plato", plato);
		return "Platos/platoDetail";
	}

	@RequestMapping("/deletePlato/{id}")
	public String eliminar(@PathVariable(value = "id") long id, Model model) {
		try {
			pla_imp.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/listPlatos";
	}
}
