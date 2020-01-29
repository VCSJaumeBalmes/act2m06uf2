package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(UsuariRepository repository) {
		return (args) -> {
			// save a few usuaris
			repository.save(new Usuari("Jack", "Bauer"));
			repository.save(new Usuari("Chloe", "O'Brian"));
			repository.save(new Usuari("Kim", "Bauer"));
			repository.save(new Usuari("David", "Palmer"));
			repository.save(new Usuari("Michelle", "Dessler"));

			// fetch an individual usuari by login and password
			Usuari usuari = repository.findByLoginAndPassword("Jack", "Bauer");
			log.info("Usuari found with findByLoginAndPassword('Jack','Bauer'):");
			log.info("--------------------------------");
			log.info(usuari.toString());
			log.info("SUCCESS");
		};
	}
}
