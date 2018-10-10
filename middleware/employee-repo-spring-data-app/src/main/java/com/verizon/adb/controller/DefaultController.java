package com.verizon.adb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	

	@GetMapping({"","/","/home"})
	
	public String handleRootRequest(){
		return "index" ;
		}

}




