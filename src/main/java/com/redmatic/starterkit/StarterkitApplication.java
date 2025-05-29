package com.redmatic.starterkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.redmatic.starterkit")
@EnableJpaAuditing
public class StarterkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterkitApplication.class, args);
	}

}
