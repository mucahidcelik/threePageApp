package com.threePageApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
	@Autowired
	private PersonRepository people;
	
	@GetMapping("/")
	String index(Model model) {
		model.addAttribute("people", people.findAll());
		return "index";
	}
	
	@GetMapping("/giris")
	String giris(Model model) {
		return "giris";
	}
	
	@GetMapping("/sabitMetin")
	String sabitMetin(Model model) {
		return "sabitMetin";
	}
	
	@PostMapping(value = "/save")
	String save(String name, String surname) {
		people.save(new Person(name, surname));
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	String delete(String id) {
		people.deleteById(Integer.parseInt(id));
		return "redirect:/";
	}
}
