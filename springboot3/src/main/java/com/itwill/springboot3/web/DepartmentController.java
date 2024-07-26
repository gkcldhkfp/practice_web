package com.itwill.springboot3.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.dto.DepartmentDetailsDto;
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
	public void list(@RequestParam(name="p", defaultValue = "0") int pageNo, Model model) {
		log.info("list()");
		
		Page<Department> list = deptSvc.read(pageNo, Sort.by("id"));
		
		model.addAttribute("page", list);
		
	}
	
	@GetMapping("/details")
	public void details(@RequestParam(name = "dname") String departmentName, Model model) {
		log.info("details(departmentName={})", departmentName);
		
		DepartmentDetailsDto dto = deptSvc.read(departmentName);
		model.addAttribute("department", dto);
		
	}
	
	
}
