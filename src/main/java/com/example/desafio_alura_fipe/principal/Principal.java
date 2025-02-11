package com.example.desafio_alura_fipe.principal;

import java.util.Scanner;

public class Principal {

	private Scanner sc = new Scanner(System.in);

	private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";

	public void exibirMenu() {
		System.out.println("Digite o veículo desejado: ");
		System.out.printf("Carro%nCaminhão%nMoto%n");
		String opcao = sc.nextLine();

		System.out.println();
		System.out.println("Você selecionou: " + opcao);
	}
}
