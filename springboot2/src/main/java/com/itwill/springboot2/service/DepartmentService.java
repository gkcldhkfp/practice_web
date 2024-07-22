package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {
	
	private final DepartmentRepository depRepo;
	
	public List<Department> read() {
		log.info("Department Read()");
		
		return depRepo.findAll();
	}
	
	public Department readById(int id) {
		log.info("dept readById()");
		
		return depRepo.findById(id).get();
	}
	
}
