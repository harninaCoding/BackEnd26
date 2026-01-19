package com.adorno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class GreetingsController {
	private String infoCompartida;

	@RequestMapping("/greeting")
	// agregar un parametro en la navegacion
	public String greeting(Model model, @RequestParam String parametro) {
		model.addAttribute("parametro", parametro);
		return "saySomething";
	}

	@RequestMapping(value = "/procesarFormulario", method = RequestMethod.POST)
	public String procesarFormulario(@RequestParam String info, HttpSession sesion) {
		sesion.setAttribute("infoUsuario", info);
		infoCompartida = info;
		return "resultado_formulario";
	}
	
	@RequestMapping("/mostrarDatos")
	public String mostrarDatos(Model model, HttpSession sesion) {
		String infoUsuario = (String) sesion.getAttribute("infoUsuario");
		model.addAttribute("infoUsuario", infoUsuario);
		model.addAttribute("infoCompartida", infoCompartida);
		return "datos";
	}
}
