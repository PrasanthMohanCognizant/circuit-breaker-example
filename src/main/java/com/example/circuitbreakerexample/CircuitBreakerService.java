package com.example.circuitbreakerexample;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakerService {

    private final RestTemplate restTemplate;

    public CircuitBreakerService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @HystrixCommand(fallbackMethod = "fallback")
    public String greetings(){
        return this.restTemplate.getForObject("http://localhost:8090/greetings", String.class);
    }

    public String fallback(){
        return "Hello Fallback";
    }
}
