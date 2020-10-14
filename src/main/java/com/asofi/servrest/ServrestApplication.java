package com.asofi.servrest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.service.EmpresasService;
import com.asofi.servrest.service.EmpresasServiceimpl;

@SpringBootApplication
public class ServrestApplication {
	@Autowired
	
	public static void main(String[] args) {
		
	    SpringApplication.run(ServrestApplication.class, args);	  
	    
        
	}

}
