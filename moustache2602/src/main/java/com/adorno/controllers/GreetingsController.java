package com.adorno.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adorno.services.UserService;

@Controller
public class GreetingsController {

	// para inyectar el servicio hay dos formas
	// 1 la antigua
//	@Autowired
//	private UserService userService;
	// 2 la forma que prefiere Spring
	private final UserService userService;

	public GreetingsController(UserService userService) {
		super();
		this.userService = userService;
	}

	// Model es un objeto interno de Spring MVC que sirve para definir
	// variables en el template de html
	@RequestMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", "jupiter");
		model.addAttribute("cantidad", userService.getNumUsers());
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
