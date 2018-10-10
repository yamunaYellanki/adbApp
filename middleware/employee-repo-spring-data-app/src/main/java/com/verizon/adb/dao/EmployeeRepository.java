

package com.verizon.adb.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.verizon.adb.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	List<Employee> findAllByLastName(String lastName);
	

	
	
}
