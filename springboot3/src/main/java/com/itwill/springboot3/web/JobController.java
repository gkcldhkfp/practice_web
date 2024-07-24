package com.itwill.springboot3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.service.JobService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RequestMapping("/job")
@Controller
@RequiredArgsConstructor
public class JobController {

	private final JobService jobSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		
		model.addAttribute("jobs", jobSvc.read());
		
	}
	
	@GetMapping("/details/{id}")
	public String list(Model model, @PathVariable String id) {
		log.info("list");
		
		model.addAttribute("job", jobSvc.read(id));
		
		return "job/details";
	}
	
	
}
