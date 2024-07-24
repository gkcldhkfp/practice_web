package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaQueryMethodTest {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void test() {
		List<Employee> list;
//		list = empRepo.findByDepartmentId(30);
//		list = empRepo.findByFirstName("Steven");
//		list = empRepo.findByFirstNameContaining("te");		
//		list = empRepo.findByFirstNameLike("%te%");		
//		list = empRepo.findByFirstNameContainingIgnoreCase("Te");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("TE");
//		list = empRepo.findBySalaryGreaterThan(20000.0);
//		list = empRepo.findBySalaryLessThan(2500);
//		list = empRepo.findBySalaryBetween(2000, 2200);
//		list = empRepo.findByHireDateGreaterThan(ld1);
//		list = empRepo.findByHireDateLessThan(ld1);
//		LocalDate ld1 = LocalDate.of(2002,1,1);
//		LocalDate ld2 = LocalDate.of(2003,1,1);
//		list = empRepo.findByHireDateBetween(ld1, ld2);
//		list = empRepo.findByDepartmentDepartmentName("IT");
//		list = empRepo.findByDepartmentLocationCity("Seattle");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("te", "te");
//		list = empRepo.findByName("tE", "Te");
//		list = empRepo.findByName2("te");
//		list = empRepo.findByDeptName("IT");
//		list = empRepo.findByCity("Seattle");
//		list = empRepo.findByCountry("Canada");
		list = empRepo.findByTest("Canada");
		
		list.forEach((x) -> {log.info(""+x.getDepartment());});
	}
	
	
}
