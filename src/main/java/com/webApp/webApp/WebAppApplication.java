package com.webApp.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication //Escanea todas las clases anotadas con @Configuration
public class WebAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
}
