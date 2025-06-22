package com.example.statistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatisticsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		marcador(01);
		exemplo1();
		marcador(02);
		exemplo2();
		marcador(03);
		exemplo3();
		marcador(04);
		exemplo4();
		marcador(05);
		exemplo5();
		marcador(06);
		exemplo6();
	}

	/**
	 * Cria um marcador para separar e identificar cada exemplo da aplicação com
	 * stream e estatisticas
	 * 
	 * @param numExampleApplication
	 */
	private static void marcador(int numExampleApplication) {
		System.out.println("\n************ Exemplo de aplicação " + numExampleApplication);
	}

	/**
	 * Converte uma List de Integer para int, depois obtem estatisticas com
	 * IntSummaryStatistics
	 */
	private static void exemplo1() {
		List<Integer> numerosList = Arrays.asList(10, 20, 30, 40, 50);
		IntSummaryStatistics st = numerosList.stream()
				.mapToInt(Integer::intValue) // convert a lista de Integer em int (primitivo)
				.summaryStatistics(); // obtem as estatisticas
		System.out.println(String.format("""
				Maior valor da lista eh: %d
				Menor valor: %d
				Quantidade de valores: %d
				Soma da lista: %d
				Media da lista: %d
									""", st.getMax(), st.getMin(), (int) st.getCount(), (int) st.getSum(),
				(int) st.getAverage()));
	}

	/**
	 * Map a chave eh um Integer que representa o tamanho da string
	 * List<String> eh a respectiva string da lista a ser agrupada
	 * Coleta o resultado para uma nova lista, agrupando (chave:valor) de acordo
	 * com o tamano da string, ex.: java, code devem estar em mesmo grupo.
	 */
	private static void exemplo2() {
		List<String> palavras = Arrays.asList("java", "stream", "lambda", "generics", "oracle", "code");

		Map<Integer, List<String>> agrupamento = palavras.stream()
				.collect(Collectors.groupingBy(String::length));

		System.out.println(agrupamento);

	}

	/**
	 * Arrays.asList é uma forma de converter um vetor em List.
	 * Na lista de nomes, cada nome ocupa uma posição/index;
	 * Ao concatenar, teremos uma String contendo todos os nomes
	 * separados por virgula
	 */
	private static void exemplo3() {
		List<String> nomes = Arrays.asList("Alice", "Bob", "Charlise");

		String nomesConcatenados = nomes.stream()
				.collect(Collectors.joining(", "));

		System.out.println(nomesConcatenados);
	}

	/**
	 * Calcula soma dos quadrados de cada numero par da lista
	 * reduce -> reduz os elementos a um unico valor, sendo que o zero (0), indica o
	 * valor inicial; Integer::sum é a função
	 * que soma dois valores, neste caso, soma de dois a dois, até somar todos
	 * elemtos da lista no stream
	 */
	private void exemplo4() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int somaDosQuadrados = numeros.stream()
				.filter(n -> n % 2 == 0) // filtra apenas os pares
				.peek(n -> System.out.println("par: " + n)) // permite "espiar" a operação
				.map(n -> n * n) // cira um map, fazendo o quadrado de cada valor par
				.peek(n -> System.out.println("quadrado: " + n))
				.reduce(0, Integer::sum); // reduz os elementos a um unico valor, comando de dois em dois
		System.out.println(somaDosQuadrados);
	}

	/**
	 * Para uma lista de numeros inteiros, separe-os por ímpares
	 */
	private static void exemplo5() {
		List<Integer> numerosList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> impares = numerosList.stream()
				.filter(n -> n % 2 != 0)
				.collect(Collectors.toList());

		impares.forEach(System.out::println);
	}

	/**
	 * 
	 */
	private static void exemplo6() {
		List<Produto> produtos = Arrays.asList(
				new Produto("cadeira", 300.0, "moveis"),

				new Produto("smartphone", 4500.0, "eletronicos"),
				new Produto("pendrive", 25.0, "eletronicos"),
				new Produto("monitor", 499.0, "eletronicos"),
				new Produto("teclado", 50.0, "eletronicos"),
				new Produto("notebook", 1200.0, "eletronicos"),

				new Produto("mesa", 700.0, "moveis"));

		// agrupando produtos por categoria
		Map<String, List<Produto>> produtosAgrupadosPorCategoria = produtos.stream()
				.collect(Collectors.groupingBy(Produto::getCategory));

		System.out.println("\nMap de produtos por categoria: \n" + produtosAgrupadosPorCategoria);

		// contando o numero de produtos de cada categoria e armazenando em um Map
		Map<String, Long> contagemPorCategoria = produtos.stream()
				.collect(Collectors.groupingBy(Produto::getCategory, Collectors.counting()));

		System.out.println("\nQuantidade de produtos por categoria: " + contagemPorCategoria);

		// produto mais caro de cada categoria da lista de produtos
		Map<String, Optional<Produto>> maisCaroPorCategoria = produtos.stream()
				.collect(Collectors.groupingBy(Produto::getCategory,
						Collectors.maxBy(Comparator.comparing(Produto::getPrice))));

		System.out.println("\nProduto mais caro por categoria: " + maisCaroPorCategoria);
		// utilizando isPresent para acessar produto Optional
		for (Map.Entry<String, Optional<Produto>> entry : maisCaroPorCategoria.entrySet()) {
			System.out.print("Categoria: " + entry.getKey() + " - ");
			entry.getValue().ifPresentOrElse(
					produto -> System.out.println("Mais caro: " + produto),
					() -> System.out.println("Nenhum produto encontrado"));
		}

		// calculando total de preços dos produtos em cada categoria e armazenando
		// resultado em um Map<String, Double>
		Map<String, Double> totalPreçoPorCategoria = produtos.stream()
				.collect(Collectors.groupingBy(
						Produto::getCategory,
						Collectors.summingDouble(Produto::getPrice)));

		System.out.println("\nSoma de precos por categoria de produtos: \n"+totalPreçoPorCategoria);
	}

}
