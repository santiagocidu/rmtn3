package com.machetico.rmtn.app.rmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.machetico.rmtn.app.rmtn.implement.CarritoImplement;
import com.machetico.rmtn.app.rmtn.implement.PedidoImplement;
import com.machetico.rmtn.app.rmtn.implement.PlatoImplement;
import com.machetico.rmtn.app.rmtn.model.Carrito;
import com.machetico.rmtn.app.rmtn.model.Pedido;

@Controller
public class CarritoController {
	
	@Autowired
	private CarritoImplement car_imp;
	
	@Autowired
	private PedidoImplement ped_imp;
	
	@Autowired
	private PlatoImplement pla_imp;
	
	@GetMapping("/allCar")
	public String allCar(Model modelo) {
		modelo.addAttribute("carrito", this.car_imp.findALL());
		return "/Carrito/carrito";
	}
	
	@GetMapping("/allCarEmp")
	public String allCarEmp(Model modelo) {
		modelo.addAttribute("carrito", this.car_imp.findALL());
		return "/Empleado/carrito";
	}
	
	@GetMapping("/mapCar")
	public String mapCar(Model modelo) {
		Carrito car = new Carrito();
		modelo.addAttribute("car", car);
		modelo.addAttribute("plato", this.pla_imp.listAll());
		modelo.addAttribute("pedido", this.ped_imp.findALL());
		return"/Carrito/carritoCreate";
	}
	
	@GetMapping("/getCarr/{id}")
	public String getIdCarr(@PathVariable long id, Model modelo) {
		Carrito carrito = new Carrito();
		modelo.addAttribute("carrito", carrito);
		modelo.addAttribute("pedido", this.ped_imp.findALL());
		modelo.addAttribute("plato", this.pla_imp.listAll());
		return "/Carrito/carritoEdit";
	}
	
	@PostMapping("/saveCar")
	public String updateCar(@ModelAttribute("car") Carrito car) {
		Pedido ped = this.ped_imp.findById(car.getPedido().getIdpedido());
		car.setPedido(ped);
		this.car_imp.update(car);
		return"redirect:/allCar";
	}
	
	@GetMapping("/deleteCar{id}")
	public String deleteCar(@PathVariable long id) {
		Carrito car = this.car_imp.findById(id);
		this.car_imp.delete(car);
		return "redirect:/allCar";
	}
	
}
