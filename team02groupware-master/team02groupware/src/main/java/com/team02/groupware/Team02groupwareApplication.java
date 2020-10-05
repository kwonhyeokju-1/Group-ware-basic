package com.team02.groupware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.team02.groupware")
public class Team02groupwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team02groupwareApplication.class, args);
		
	}
	

}
