package com.fhce.egovf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InventarioApplication /*extends SpringBootServletInitializer*/{
	
	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(InventarioApplication.class);
	}*//* para produccion*/

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

}
