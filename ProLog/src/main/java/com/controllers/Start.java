package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Start {

	@RequestMapping(value = "/start",method=RequestMethod.POST)
	public String isValid(@RequestParam("nm") String name,@RequestParam("pw") String pass) {
	
		Mn m=new Mn();
		Boolean b=m.fetch(name, pass);
		if (b) {
			return "view1";
		} else {
			return "view2";
		}
	}	
}
