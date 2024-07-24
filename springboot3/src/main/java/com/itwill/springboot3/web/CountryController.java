package com.itwill.springboot3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.service.CountryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

	private final CountryService coSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("countries", coSvc.read());
		
	}
	
	@GetMapping("/details/{id}")
	public String details(Model model, @PathVariable String id) {
		
		model.addAttribute("country", coSvc.read(id));
		
		return "country/details";
	}
	
	
}
