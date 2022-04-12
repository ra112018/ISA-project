package com.example.projectIsa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectIsaApplication {
	
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ProjectIsaApplication.class, args);
	}

	

}
