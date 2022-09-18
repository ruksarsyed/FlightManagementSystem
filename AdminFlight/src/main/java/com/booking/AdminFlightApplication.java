package com.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AdminFlightApplication {

	 @Bean
//   @LoadBalanced
   RestTemplate restTemplate() {
       return new RestTemplate();
   }
   @Bean
   public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2);
   }
	
	public static void main(String[] args) {
		SpringApplication.run(AdminFlightApplication.class, args);
	}
	

}
