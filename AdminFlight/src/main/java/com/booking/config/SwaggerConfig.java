//package com.booking.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
////@EnableSwagger2
//
//public class SwaggerConfig {
//
//	 @Bean
//	 public Docket postApi() { 	 
//		 return new Docket(DocumentationType.SWAGGER_2).select()
//		         .apis(RequestHandlerSelectors.basePackage("com.booking")).build();
//		 } 
//	 public ApiInfo apiInfo() {
//	  return new ApiInfoBuilder().title("AdminFlight")
//	  .description("Sample Documentation on Admin Abilities for complete System")
//	  .termsOfServiceUrl("#")
//	  .license("AdminFlight Api License").version("v1.0").build(); }
//	 
//}