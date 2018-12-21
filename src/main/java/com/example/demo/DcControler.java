package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcControler {
	@Autowired 
	DiscoveryClient  discoryClient;
	@GetMapping("/dc")
	public String dc() {
	    String services = "Services: " + discoryClient.getServices();
	    System.out.println(services);
	    return services;
	}
}
