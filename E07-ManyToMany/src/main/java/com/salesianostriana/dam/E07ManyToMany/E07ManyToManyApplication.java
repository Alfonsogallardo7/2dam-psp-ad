package com.salesianostriana.dam.E07ManyToMany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class E07ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(E07ManyToManyApplication.class, args);
	}

}
