package com.example.organization_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				summary = "Organization Service Application Rest APIs",
				description = "Organization Service Application Rest APIs Doc",
				title = "Organization Service Application",
				contact = @Contact(
						name = "Sumit Sharma",
						email = "Sumit4652@gmail.com"
				),
				version = "v1.0",
				license = @License(name = "Apache 2.0")
		),externalDocs = @ExternalDocumentation(description = "Organization APIs")
)
@SpringBootApplication
public class OrganizationServiceApplication {

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
