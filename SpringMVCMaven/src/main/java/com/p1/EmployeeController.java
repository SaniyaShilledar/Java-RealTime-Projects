package com.p1;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/submit")
public class EmployeeController {
	
	public String saveEmployee(Model m,Employee e) {
		System.out.println("Eno : "+e.getEno());
		System.out.println("Ename : "+e.getEname());
		System.out.println("Esalary : "+e.getEsalary());
		
		m.addAttribute(e);
		
		
		return "display";
		
	}
	
	

}
