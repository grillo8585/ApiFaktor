package com.asofi.servrest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ServrestApplication {
	@Autowired
	
	public static void main(String[] args) {
		
	    SpringApplication.run(ServrestApplication.class, args);	  
	    
	}

}
