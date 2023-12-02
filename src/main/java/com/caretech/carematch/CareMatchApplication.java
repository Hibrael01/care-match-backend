package com.caretech.carematch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CareMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareMatchApplication.class, args);
	}

}
