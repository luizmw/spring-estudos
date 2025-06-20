package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * 1
		 * filtrando inteiros da lista de numeros com stream
		 * obs: arrays é um metodo da classe Arrays que converte um array em List
		 */
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> numerosPares = numeros.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());

		delimitador(1, "Imprimindo lista original");
		numeros.forEach(System.out::println);
		System.out.println("Imprimindo lista de numeros pares:");
		numerosPares.forEach(System.out::println);

		/**
		 * 2
		 * Convertendo lista de strings para maiusculo - uppercase
		 */
		List<String> words = Arrays.asList("java", "stream", "lambda", "generics");
		List<String> wordsInUpperCase = words.stream()
				.sorted()
				.map(String::toUpperCase)
				.toList(); // ação final - torna a lista imutável
		delimitador(2, "Imprimindo a lista de Words original");
		words.forEach(System.out::println);
		System.out.println("Imprimindo a lista de words transformada:");
		wordsInUpperCase.forEach(System.out::println);

		/**
		 * 3
		 * Filtrado numeros ímpares e multiplicando cada numero por 2 - modificando na
		 * lista original
		 */
		List<Integer> numerosLista = listaDeNumeros(10);
		delimitador(3, "Imprimindo lista original");
		numerosLista.forEach(System.out::println);

		numerosLista = numerosLista.stream()
				.filter(n -> n % 2 != 0)
				.map(n -> n * 2)
				.collect(Collectors.toList());
		System.out.println("Imprimindo numeros impares *2");
		numerosLista.forEach(System.out::println);

		/**
		 * 4
		 * Removendo strings duplicadas de uma lista - alterando na lista original
		 */
		List<String> palavrasDuplicadas = Arrays.asList("apple", "microsoft", "apple", "ibm", "oracle", "oracle",
				"positivo");
		palavrasDuplicadas = palavrasDuplicadas.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		delimitador(4, "Imprimindo lista de palavras sem duplicata");
		palavrasDuplicadas.forEach(System.out::println);

		/**
		 * 5
		 * ordenando lista de sublistas de numeros inteiros
		 */
		List<List<Integer>> listaDeNumeros = Arrays.asList(
				Arrays.asList(1, 2, 3, 4),
				Arrays.asList(5, 6, 7, 8),
				Arrays.asList(9, 10, 11, 12));

		List<Integer> listao = listaDeNumeros.stream()
				.flatMap(List::stream) // coloca todas as sublistas em uma unica stream
				.filter(StreamApplication::ehPrimo) // na classe main, chama o metodo ehPrimo para filtrar
				.sorted() // ordena em ordem crescente
				.collect(Collectors.toList()); // coleta resultado em 'listao'

		delimitador(5, "Imprimindo numeros primos (divisiveis por 1 e por ele mesmo) de 3 sublistas, de 1 a 12");
		listao.forEach(System.out::println);

		/**
		 * 6
		 * Para um objeto Pessoa (nome, idade),
		 * filtrar as pessoas com mais de 18 anos, extrair nomes e imprimir em ordem
		 * alfabética
		 */
		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("arsenio", 50),
				new Pessoa("boro", 10),
				new Pessoa("cadmio", 12),
				new Pessoa("deuterio", 14),
				new Pessoa("enxofre", 52));
		List<String> pessoasMaiores = pessoas.stream()
				.filter(p -> p.getIdade() > 18)
				// .map(p -> p.getNome()) //ou
				.map(Pessoa::getNome)
				.sorted()
				.collect(Collectors.toList());

		delimitador(6, "lista de pessoas:");
		pessoas.forEach(System.out::println);
		System.out.println("Lista de pessoas > 18:");
		pessoasMaiores.forEach(System.out::println);

		/**
		 * 7
		 * Você tem uma lista de objetos do tipo Produto, onde cada produto possui os
		 * atributos nome (String), preco (double) e categoria (String). Filtre todos os
		 * produtos da categoria "Eletrônicos" com preço menor que R$ 1000, ordene-os
		 * pelo preço em ordem crescente e colete o resultado em uma nova lista.
		 */

		List<Produto> produtos = Arrays.asList(
				new Produto("relogio", 1100.0, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("kindle", 999.99, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("celular", 1500.0, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("teclado", 75.0, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("pendrive", 25.0, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("fones", 12.90, CategoriaProduto.ELETRONICOS.getNome()),
				new Produto("cabo usb", 5.50, CategoriaProduto.ELETRONICOS.getNome()),

				new Produto("martelo", 52.0, CategoriaProduto.FERRAMENTAS.getNome()),
				new Produto("esquadro", 19.90, CategoriaProduto.FERRAMENTAS.getNome()),
				new Produto("serrote", 89.90, CategoriaProduto.FERRAMENTAS.getNome()),
				new Produto("FURADEIRA", 995.0, CategoriaProduto.FERRAMENTAS.getNome()));

		List<Produto> produtosEletronicosBaratos = produtos.stream()
				.filter(p -> p.getCategory().equals(CategoriaProduto.ELETRONICOS.getNome()) && p.getPrice() < 1000)
				// .sorted((p1, p2)-> Double.compare(p1.getPrice(), p2.getPrice())) //ou:
				.sorted(Comparator.comparing(Produto::getPrice))
				.collect(Collectors.toList());

		delimitador(7, "Lista de produtos: ");
		produtos.forEach(System.out::println);
		System.out.println("\nImprimindo apenas produtos eletronicos abaixo de R$1000 ordenados por preco ");
		produtosEletronicosBaratos.forEach(System.out::println);

		/**
		 * 8
		 * modificando o exercicio anterior para exibir apenas os 3 produtos mais
		 * baratos dos eletronicos < mil R$
		 */

		produtosEletronicosBaratos = produtosEletronicosBaratos.stream()
				.limit(3)
				.collect(Collectors.toList());

				delimitador(8, "Imprimindo 3 produtos eletronicos mais baratos");
				produtosEletronicosBaratos.forEach(System.out::println);
	}

	/**
	 * 
	 * @param numero
	 * @return
	 */
	public static boolean ehPrimo(int numero) {
		if (numero < 2)
			return false;
		int limite = (int) Math.sqrt(numero);
		return IntStream.rangeClosed(2, limite)
				.noneMatch(divisor -> numero % divisor == 0);
	}

	/**
	 * 
	 * @param numero
	 * @param mensagem
	 */

	public static void delimitador(int numero, String mensagem) {
		System.out.println("\n" + "=".repeat(100));
		System.out.print(String.format("""
				*********************************************************************************
				%d )\n
				%s
				""", numero, mensagem));
	}

	/**
	 * cria lista usando stream:
	 * 
	 * @param tamanho
	 * @return
	 */
	public static List<Integer> listaDeNumeros(int tamanho) {
		return IntStream.range(0, tamanho)
				.boxed()
				.collect((Collectors.toList()));
	}

}
