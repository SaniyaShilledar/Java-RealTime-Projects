package com.p1.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logincontroller")
public class LoginContriller {

//	@RequestMapping("/login")
//	public String login() {
//
//		return "display.jsp";
//	}
	@RequestMapping("/hello")
	public String redirect() {
		return "viewpage";
	}

	@RequestMapping("/helloagain")
	public String display() {
		return "final";
	}
}
