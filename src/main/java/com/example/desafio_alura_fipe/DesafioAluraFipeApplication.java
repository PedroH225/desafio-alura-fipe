package com.example.desafio_alura_fipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAluraFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAluraFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("oi");		
	}

}
