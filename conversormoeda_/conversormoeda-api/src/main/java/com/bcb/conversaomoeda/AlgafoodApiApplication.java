package com.bcb.conversaomoeda;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bcb.conversaomoeda.infraestructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class AlgafoodApiApplication {

	private static final String UTC = "UTC";

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone(UTC));
		SpringApplication.run(AlgafoodApiApplication.class, args);
	}

}
