package com.adorno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingsController {
	
	//Model es un objeto interno de Spring MVC que sirve para definir 
	//variables en el template de html
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", "jupiter");
		return "greeting_template";
	}

}
