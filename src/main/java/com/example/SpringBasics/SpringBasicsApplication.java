package com.example.SpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.SpringBasics.model.Alien;

@SpringBootApplication		
public class SpringBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);
		Alien obj =  context.getBean(Alien.class);
		obj.code();
	}

}
