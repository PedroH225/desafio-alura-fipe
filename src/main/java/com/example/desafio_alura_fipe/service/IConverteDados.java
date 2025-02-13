package com.example.desafio_alura_fipe.service;

public interface IConverteDados {
	<T> T converterDados(String json, Class<T> classe);
}
