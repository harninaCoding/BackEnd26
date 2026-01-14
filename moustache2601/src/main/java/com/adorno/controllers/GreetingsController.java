package com.adorno.controllers;

import java.util.Arrays;
import java.util.List;

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
	
	@RequestMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("name", "world");
		model.addAttribute("silent", false);
		return "basic_template";
	}
	@RequestMapping("/list")
	public String iteration(Model model) {
		List<String> colors = Arrays.asList("Red", "Blue", "Green");
		model.addAttribute("colors", colors);
		return "list_template";
	}
}
