package com.itwill.springboot3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.service.RegionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/region")
@Controller
public class RegionController {

	private final RegionService regSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		
		model.addAttribute("regions", regSvc.read());
	}
	
	@GetMapping("/details/{id}")
	public String details(Model model, @PathVariable Integer id) {
		log.info("details");
		
		model.addAttribute("region", regSvc.read(id));
		
		return "region/details";
	}
	
}
