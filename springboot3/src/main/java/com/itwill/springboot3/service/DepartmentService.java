package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {
	
	@Autowired
	private final DepartmentRepository deptRepo;
	
	public List<Department> read() {
		
		return deptRepo.findAll();
	}
	
	public Department read(Integer id) {
		
		return deptRepo.findById(id).orElseThrow();
	}

}
