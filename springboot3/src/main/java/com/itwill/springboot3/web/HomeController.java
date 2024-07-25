package com.itwill.springboot3.web;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		log.info("home()");
		
		return "index";
	}
	
}