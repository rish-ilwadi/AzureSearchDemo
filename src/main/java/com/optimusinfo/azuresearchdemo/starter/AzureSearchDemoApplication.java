package com.optimusinfo.azuresearchdemo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * This class is used for starting the Spring Boot application
 * 
 * @author Optimus
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.optimusinfo.azuresearchdemo")
@ImportResource("classpath:context.xml")
public class AzureSearchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureSearchDemoApplication.class, args);
	}
}
