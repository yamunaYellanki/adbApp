package com.verizon.emp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.verizon.emp.model.Emplyoee;
@Repository
public interface EmplyoeeRepository extends JpaRepository<Emplyoee, Long> {
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String 	Emplyoee);
	
	Emplyoee findByMobileNumber(String mobileNumber);
	Emplyoee findByEmailId(String emailId);
	
	List<Emplyoee> findAllByLastName(String lastName);
	List<Emplyoee> findAllByDept(String dept);
	}
