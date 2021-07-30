package com.jwt.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtApplication {
	//create-drop
	//SessionFactory가 시작될때 Drop, Create, Alter 종료될때 Drop

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
