package com.p2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public  class SpringWebIntializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException{
		AnnotationConfigWebApplicationContext container=new AnnotationConfigWebApplicationContext();
		container.register(SpringMVCConfi.class);
		container.setServletContext(servletContext);
		Dynamic servlet=servletContext.addServlet("spring", new DispatcherServlet(container));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(3);
		
		
	}

}
