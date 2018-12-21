package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class RunnerTheSecond implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		   System.out.println("The Runner 22222222222 start to initialize ******");
	}

}
