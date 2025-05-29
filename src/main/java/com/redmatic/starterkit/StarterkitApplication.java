package com.redmatic.starterkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.redmatic.starterkit")
public class StarterkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterkitApplication.class, args);
	}

}
