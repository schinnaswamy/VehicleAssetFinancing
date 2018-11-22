package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	

	    @Bean
	    public Docket produceApi(){
	    return new Docket(DocumentationType.SWAGGER_2)
	    .apiInfo(apiInfo())
	    .select()
	    .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
	    //.paths(paths())
	    .build();
	}
	// Describe your apis
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	    .title("Vehicle Asset Financing Application Rest APIs")
	    .description("This page lists all the rest apis for Vehicle Asset Financing Application.")
	    .version("1.0-SNAPSHOT")
	    .build();
	}


}
