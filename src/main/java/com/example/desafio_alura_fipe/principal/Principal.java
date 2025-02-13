package com.example.desafio_alura_fipe.principal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.desafio_alura_fipe.model.Ano;
import com.example.desafio_alura_fipe.model.Marca;
import com.example.desafio_alura_fipe.model.Modelo;
import com.example.desafio_alura_fipe.model.ModeloAno;
import com.example.desafio_alura_fipe.model.Veiculo;
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
		var json = consumo.obterDados(ENDERECO + "/" + opcao.toLowerCase() + "/marcas");

		var cd = new ConverteDados();
		List<Marca> marcas = Arrays.asList(cd.converterDados(json, Marca[].class));

		for (Marca marca : marcas) {
			System.out.println("Código: " + marca.codigo() + ", Nome: " + marca.nome());
		}

		System.out.println();
		System.out.printf("Digite o código da marca desejada: ");
		String marca = sc.nextLine();

		System.out.println();

		var jsonModelos = consumo.obterDados(ENDERECO + "/" + opcao + "/marcas/" + marca + "/modelos");

		ModeloAno modeloAno = cd.converterDados(jsonModelos, ModeloAno.class);

		List<Modelo> modelos = Arrays.asList(modeloAno.modelos());

		for (Modelo modeloTemp : modelos) {
			System.out.println("Código: " + modeloTemp.codigo() + ", Nome: " + modeloTemp.nome());
		}

		System.out.println();
		System.out.printf("Digite um trecho do modelo desejado: ");
		String trechoModelo = sc.nextLine();

		Optional<Modelo> modeloBusca = modelos.stream().filter(m -> m.nome().contains(trechoModelo)).findFirst();

		while (modeloBusca.isEmpty()) {
			System.out.println();
			System.out.printf("Modelo não encontado, digite novamente: ");
			String busca = sc.nextLine();
			modeloBusca = modelos.stream().filter(m -> m.nome().contains(busca)).findFirst();
		}

		var jsonAnos = consumo.obterDados(
				ENDERECO + "/" + opcao + "/marcas/" + marca + "/modelos/" + modeloBusca.get().codigo() + "/anos");

		List<Ano> anos = Arrays.asList(cd.converterDados(jsonAnos, Ano[].class));

		System.out.println();
		System.out.println("Preços dos modelos por ano: ");

		for (Ano ano : anos) {
			var jsonVeiculo = consumo.obterDados(ENDERECO + "/" + opcao + "/marcas/" + marca + "/modelos/"
					+ modeloBusca.get().codigo() + "/anos/" + ano.codigo());

			Veiculo veiculo = cd.converterDados(jsonVeiculo, Veiculo.class);
			System.out.println(veiculo);
		}

	}
}
