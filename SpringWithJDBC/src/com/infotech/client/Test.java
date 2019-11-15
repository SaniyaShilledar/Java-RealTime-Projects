package com.infotech.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotech.model.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService=ctx.getBean("employeeService",EmployeeServiceImpl.class);
		
		fetchAllDetail(employeeService);
		
		ctx.close();
		}
	

	private static void fetchAllDetail(EmployeeService employeeService) {
		// TODO Auto-generated method stub
String un="";
String ps="";
		List<Employee> empList=employeeService.getAllInfor();
		for(Employee e:empList) {
		 un=e.getUsername();
		 ps=e.getPassword();
		}
	System.out.println("usename :"+un);
	System.out.println("password :"+ps);

	}
}

