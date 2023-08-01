package com.Repository.Registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableEurekaServer
public class RegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistoryApplication.class, args);
	}

}
