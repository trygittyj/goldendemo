package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("The service started.");
		Map<String,String> a=new HashMap<String,String>(16,(float) 0.75);
	}
}
