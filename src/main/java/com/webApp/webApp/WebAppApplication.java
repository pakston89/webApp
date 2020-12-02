package com.webApp.webApp;

import com.webApp.webApp.model.Expense;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
}
