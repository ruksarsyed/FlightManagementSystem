package com.capg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FlightBookingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingMicroserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean 
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				          .select()
				          .paths(PathSelectors.ant("/booking/**"))
				          .apis(RequestHandlerSelectors.basePackage("com.capg"))
				          .build()
				          .apiInfo(apiData());
	}

	private ApiInfo apiData() {
		return new ApiInfo(
				"Booking API", 
				"APIs for FlightBooking Microservice", 
				"1.0", 
				"Free to use", 
				new Contact("Keerthi Korrapati", "http://localhost:8003", "keerthikorrapati01@gmail.com"), 
				"API License", 
				"http://localhost:8003",
				Collections.emptyList());
	}
	
	
}
