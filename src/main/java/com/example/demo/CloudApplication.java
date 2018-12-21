package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableAutoConfiguration
//@RestController
//@EnableEurekaServer
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableEurekaServer
public class CloudApplication {
	public static void main(String[] args) {
        //new SpringApplicationBuilder(Application.class).run(args);
        new SpringApplicationBuilder(CloudApplication.class).web(true).run(args);
    }
}
