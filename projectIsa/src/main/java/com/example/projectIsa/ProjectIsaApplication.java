package com.example.projectIsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProjectIsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectIsaApplication.class, args);
	}

}
