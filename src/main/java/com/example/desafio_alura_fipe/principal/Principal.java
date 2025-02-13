package com.example.desafio_alura_fipe.principal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.desafio_alura_fipe.model.Marca;
import com.example.desafio_alura_fipe.service.ConsumoApi;
import com.example.desafio_alura_fipe.service.ConverteDados;

public class Principal {

	private Scanner sc = new Scanner(System.in);

	private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";

	public void exibirMenu() {
		System.out.println("Digite o veículo desejado: ");
		System.out.printf("Carros%nCaminhões%nMotos%n");
		String opcao = sc.nextLine();
		
		var consumo = new ConsumoApi();
		var json = consumo.obterDados(ENDERECO + "/" + opcao.toLowerCase() + "/marcas" );
		
		var cd = new ConverteDados();
		List<Marca> marcas = Arrays.asList(cd.converterDados(json, Marca[].class));	
		
		for (Marca marca : marcas) {
			System.out.println("Código: " + marca.codigo() +
					"\nNome: " + marca.nome());
		}
	}
}
