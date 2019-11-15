package com.p2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.p1")
@EnableWebMvc
public class SpringMVCConfi {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver("/jsps/",".jsp");
		return vr;
	}
	

	

}
