package com.example.SpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.SpringBasics.model.Alien;

@SpringBootApplication		
public class SpringBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicsApplication.class, args);
		
//		code for relational mapping (autowired , one to one , one to many , many to many , vist Alien.java , laptop.java from model pacakge)
//		Alien obj =  context.getBean(Alien.class);
//		obj.code();
		
//		for MVC demo
		
//		HomeController hc = context.getBean(HomeController.class);
		
	}

}
