package com.itwill.springboot3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService deptSvc;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("departments", deptSvc.read());
		
		return "department/list";
	}
	
	@GetMapping("/details/{id}")
	public String details(Model model, @PathVariable Integer id) {
		
		model.addAttribute("department", deptSvc.read(id));
		
		return "department/details";
	}
	
	
}
