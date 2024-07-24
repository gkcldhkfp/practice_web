package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Location;
import com.itwill.springboot3.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

	private final LocationService locSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		List<Location> list =  locSvc.read();
		
		model.addAttribute("locations", list);
		
	}
	
	@GetMapping("/details/{id}")
	public String details(Model model, @PathVariable int id) {
		
		model.addAttribute("location", locSvc.read(id));
		
		return "location/details";
	}
	
	
}
