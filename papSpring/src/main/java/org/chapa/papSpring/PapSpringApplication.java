package org.chapa.papSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PapSpringApplication {

	public static void main(String[] args) {
		//MAIN que deja la ejecución del aplicación en manos de Spring
		SpringApplication.run(PapSpringApplication.class, args);
	}

}
