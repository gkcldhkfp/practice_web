package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Country;
import com.itwill.springboot3.repository.CountryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryService {

	private final CountryRepository counRepo;
	
	public List<Country> read() {
		log.info("read");
		
		return counRepo.findAll();
	}
	
	public Country read(String id) {
		log.info("read");
		
		return counRepo.findById(id).orElseThrow();
	}
	
	
}
