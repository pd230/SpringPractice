package com.example.SpringBasics.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
//  Field Injection
	
//	@Autowired
//	Laptop laptop1; 
	
//	public void code() {
//		laptop1.compile();
//	}
	
	
//  Constructor Injection
	
//	@Autowired
//	Laptop laptop2;
//	public Alien(Laptop laptop) {
//		this.laptop2 = laptop;
//	}

//	public void code() {
//		laptop2.compile();
//	}
	
	
//  Setter Injection
	
	Laptop laptop3;
	
	@Autowired
	public void setLaptop3(Laptop laptop){
		this.laptop3 = laptop;
	}
	
	public void code() {
		laptop3.compile();
	}
	

}
