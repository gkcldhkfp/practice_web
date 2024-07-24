package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService empSvc;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Employee> list = empSvc.read();
		model.addAttribute("employees", list);
		
		return "employee/list";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id, Model model) {
		
		model.addAttribute("employee", empSvc.read(id));
		
		return "employee/details";
	}
	
	
}
