package com.example.desafio_alura_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloAno(
		@JsonAlias("anos") Ano[] anos,
		@JsonAlias("modelos") Modelo[] modelos
		) {

}
