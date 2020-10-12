package com.asofi.servrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

 
@EnableSwagger2 // Habilitemos el modulo de swagger2
@Configuration
@EnableWebMvc
@ComponentScan("springfoxdemo.java.swagger")

public class SwaggerConfig {
	
	@Bean // Spring sabrá que es un bean que se tiene que configurar
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) // Versión que usamos
				.select()// Inicializar un builder Patrón de diseño
				.apis(RequestHandlerSelectors.basePackage("com.asofi.servrest.controller")) // Autodocumentar las clases en el paquete
// .apis(RequestHandlerSelectors.any()) // Autodocumentar todas las clases				
				.paths(PathSelectors.any()) // que URls debe documentar 
				.build();
	}
	
}
