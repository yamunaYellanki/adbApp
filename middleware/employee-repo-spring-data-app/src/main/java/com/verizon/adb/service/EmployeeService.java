package com.verizon.adb.service;
import java.util.Date;
import java.util.List;
import com.verizon.adb.model.Employee;


public interface EmployeeService {
	
	Employee getEmployeeById(long employeeId);
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(long employeeId);
	

	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	List<Employee> findAllByLastName(String lastName);
	

}
