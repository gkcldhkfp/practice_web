package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Region;
import com.itwill.springboot3.repository.RegionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {

	private final RegionRepository regRepo;
	
	public List<Region> read() {
		log.info("read");
		
		return regRepo.findAll();
	}
	
	public Region read(Integer id) {
		log.info("read");
		
		return regRepo.findById(id).orElseThrow();
	}
	
}
