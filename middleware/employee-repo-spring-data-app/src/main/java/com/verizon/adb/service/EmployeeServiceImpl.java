package com.verizon.adb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verizon.adb.dao.EmployeeRepository;

import com.verizon.adb.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;


	@Override
	public Employee getEmployeeById(long employeeId) {
		
		Employee employee=null;
		
		Optional<Employee> optEmployee =employeeRepo.findById(employeeId);
		if(optEmployee.isPresent())
		{
			employee=optEmployee.get();
		}
		return employee;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public boolean deleteEmployee(long employeeId) {
		boolean isDeleted=false;
		if(employeeRepo.existsById(employeeId))
		{
		employeeRepo.deleteById(employeeId);
		isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByMobileNumber(String mobileNumber) {
		return employeeRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		return employeeRepo.existsByEmailId(emailId);
	}

	@Override
	public Employee findByMobileNumber(String mobileNumber) {
		return employeeRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		return employeeRepo.findByEmailId(emailId);
	}

	@Override
	public List<Employee> findAllByLastName(String lastName) {
		return employeeRepo.findAllByLastName(lastName);
	}
	

}
