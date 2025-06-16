package com.redmatic.autotab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.redmatic.autotab")
@EnableJpaAuditing
public class AutotabApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutotabApplication.class, args);
	}

}
