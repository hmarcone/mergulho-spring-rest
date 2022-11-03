package com.hmarcone.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.hmarcone.domain.repository")
//@EntityScan("com.hmarcone.domain.model")
//@EnableJpaRepositories("com.hmarcone.domain.repository")
public class LogisticaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApiApplication.class, args);
	}
}
