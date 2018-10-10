
package com.verizon.adb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.model.Employee;
import com.verizon.adb.model.Gender;
import com.verizon.adb.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeeList")
	public ModelAndView handleEmployeeList()
	{
		return new ModelAndView("clistPage","employees",employeeService.getAllEmployees());
	}
	
	@GetMapping("/addEmployee")
	public ModelAndView handleNewEmployee()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("addEmployeePage");
		mv.addObject("employee",new Employee());
		mv.addObject("genders", Gender.values());
		
		return mv;
	}
	
	@PostMapping("/addEmployee")
	public ModelAndView handleAddEmployee(
			@ModelAttribute("employee") @Valid Employee employee,
		BindingResult validationResults)
	{
		ModelAndView mv = new ModelAndView();
		
		
		if(employeeService.existsByEmailId(employee.getEmailId()))
		{
			//validationResults.addError(new ObjectError("emailId","emailId already exists"));
			validationResults.rejectValue("emailId","error.contact","emailId already exists");
		}
		
		if(employeeService.existsByMobileNumber(employee.getMobileNumber()))
		{
			//validationResults.addError(new ObjectError("mobileNumber","mobl no. already exists"));
			validationResults.rejectValue("mobileNumber","error.contact","mobileNo already exists");
		}
		
		if(validationResults.hasErrors())
		{
			mv.setViewName("addEmployeePage");
			mv.addObject("employee",employee);
			mv.addObject("genders", Gender.values());
		}
		else
		{
			employeeService.addEmployee(employee);
			mv.setViewName("redirect:/employeeList");
		}
		return mv;
	}
	
	@GetMapping("/searchEmployee")
	public String handleSearchContact()
	{
		return "searchPage" ;
	}
	@PostMapping("/searchEmployee")
	public ModelAndView handleDoSearchEmployee(
			@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField
			)
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("searchPage");
		mv.addObject("pageTitle","Results for"+byField+"="+searchValue);
		
		switch(byField)
		{
		case "mobile" :
			mv.addObject("result",employeeService.findByMobileNumber(searchValue));
			break;
			
		case "email" :
			mv.addObject("result",employeeService.findByEmailId(searchValue));
			break;
			
		case "lnm" :
			mv.addObject("results",employeeService.findAllByLastName(searchValue));
			break;
		}

		return mv ;
	}
	
	
}
