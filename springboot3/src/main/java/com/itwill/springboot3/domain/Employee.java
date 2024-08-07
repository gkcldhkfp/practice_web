package com.itwill.springboot3.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder 
@Getter @ToString @EqualsAndHashCode
@Entity @Table(name = "EMPLOYEES") // EMPLOYEES 테이블에 매핑되는 엔티티.
public class Employee {
	
	@Id @Column(name = "EMPLOYEE_ID")
	private Integer id;

	// JPA는 카멜 표기법의 엔티티 필드 이름을 테이블 컬럼의 snake 표기법의 컬럼 이름으로 자동 매핑.
	// 필드: firstName --> 컬럼 이름: first_name(FIRST_NAME)
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private LocalDate hireDate;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID")
	private Job job;
	
	private Double salary;
	
	private Double commissionPct;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	
}
