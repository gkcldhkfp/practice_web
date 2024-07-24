package com.itwill.springboot2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.service.DepartmentService;
import com.itwill.springboot2.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentService deptSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("dept list");
		
		List<Department> dept = deptSvc.read();
		
		model.addAttribute("department", dept);
	}
	
	@GetMapping("/details/{id}")
	public String detail(Model model, @PathVariable int id) {
		log.info("dept details");
		
		Department dept = deptSvc.readById(id);
		
		model.addAttribute("department", dept);
		
		return "department/details";
	}

}
