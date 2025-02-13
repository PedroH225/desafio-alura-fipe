package com.example.desafio_alura_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelo(
		@JsonAlias("codigo") Integer codigo,
		@JsonAlias("nome") String nome
		) {
	
}
