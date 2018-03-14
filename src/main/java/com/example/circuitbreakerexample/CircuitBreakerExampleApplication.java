package com.example.circuitbreakerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class CircuitBreakerExampleApplication {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	CircuitBreakerService circuitBreakerService;

	@GetMapping("/")
	public String greetings() {
		return circuitBreakerService.greetings();
	}

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerExampleApplication.class, args);
	}
}
