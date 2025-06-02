package com.example.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LambdaApplication implements CommandLineRunner {
	// implementar CommandLineRunner para poder sobreescrever o metodo main
	public static void main(String[] args) {
		SpringApplication.run(LambdaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1-----------------------------------------LAMBDA WITH INTERFACE
		System.out.println("\nCriando funcao lambda para verificar se o numero eh par ou impar:");
		IMultiplicacao mult = (a, b) -> a * b;
		System.out.println("10*5=" + mult.multiplicar(10, 5));

		// 2-----------------------------------------LAMBDA EXPRESSION
		System.out.println("\nExpressao lambda para verificar se numero eh primo:");
		Function<Integer, Boolean> verificaSeEhPrimo = (numero) -> {
			if (numero <= 1)
				return false;
			if (numero == 2)
				return true;
			if (numero % 2 == 0)
				return false;
			int limite = (int) Math.sqrt(numero);
			for (int i = 3; i <= limite; i += 2) {
				if (numero % i == 0) {
					return false;
				}
			}
			return true;
		};

		// 2-alternativo-----------------------------------------LAMBDA FUNCTION
		System.out.println("\nCriando expressao lambda para verificar se o numero eh par:");
		Function<Integer, Boolean> verificaNumeroPar = n -> n % 2 == 0 ? true : false;
		if (verificaNumeroPar.apply(11)) {
			System.out.println("eh par");
		} else {
			System.out.println("eh impar");
		}
		String auxEhPrimo;
		auxEhPrimo = verificaSeEhPrimo.apply(57) ? "eh primo" : "nao eh primo";
		System.out.println("o numero 57 " + auxEhPrimo);

		// 3-----------------------------------------LAMBDA EXPRESSION
		System.out.println("\nCriando funcao lambda para converter uma string em upperCase:");
		Function<String, String> converteString = s -> s.toUpperCase();
		String strConvertida = converteString.apply("hello world lambda with java spring");
		System.out.println(strConvertida);

		// 4-----------------------------------------LAMBDA WITH INTERFACE
		System.out.println("\nVerificando palindromo:");
		IPalindromo palindromo = palavra -> palavra.equals(new StringBuilder(palavra).reverse().toString());
		System.out.println(
				"Testando expressao lambda que verifica se uma string é um palindromo:");
		System.out.println("radar: " + palindromo.verificaPalindromo("radar"));
		System.out.println("java: " + palindromo.verificaPalindromo("java"));

		// 5-----------------------------------------CONSUMER LAMBDA
		System.out.println(
				"Expressao lambda que recebe uma lista de inteiros e a devolve com cada inteiro multiplicado por 3");
		List<Integer> listaNumeros = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			listaNumeros.add(i, i);
		}
		Consumer<List<Integer>> modificaLista = lista -> {
			lista.replaceAll(n -> n * 3); // replaceAll substitui todos os valores pela expressao passada (quando nao
											// tem retorno/void)
			System.out.println(
					"lista modificada (por estar usando replaceAll, modifica a lista original passada como parametro na chamada desta function consumer.): ");
			lista.forEach(System.out::println);
		};
		modificaLista.accept(listaNumeros);

		// 6-----------------------------------------CONSUMER LAMBDA (quando nao tem
		// retorno/void)
		System.out.println("Expressao lambda que ordena uma lista de strings:");
		List<String> listaStr = Arrays.asList("adriana", "bruna", "carol", "daiane", "estefani"); // Arrays.asList é um
																									// metodo da classe
																									// Arrays do
																									// java.util que
																									// converte um array
																									// ou sequencia de
																									// elementos em uma
																									// List fixa (nao
																									// redimensionavel)

		Consumer<List<String>> ordenaLista = list -> {
			Collections.sort(list);
			System.out.println("imprimindo lista ordenada:");
			list.forEach(System.out::println);
		};
		ordenaLista.accept(listaStr);
		// outra forma de implementar via metodo compareTo() da interface comparable -
		// neste caso implementada na classe String por default:
		List<String> listaStrTwo = Arrays.asList("fernanda", "giane", "helena", "ingrid");
		listaStrTwo.sort((anterior, proximo) -> anterior.compareTo(proximo));
		System.out.println("imprimindo ordenacao atraves de outro metodo:");
		listaStrTwo.forEach(System.out::println);

		// 7-----------------------------------------BICONSUMER LAMBDA (quando ha dois
		// parametros)
		System.out.println(
				"Funcao lambda que recebe dois valores e divide o primeiro pelo segundo, lancando excecao se divisr=0");
		BiConsumer<Integer, Integer> divideValores = (v1, v2) -> {
			if (v2 == 0)
				throw new ArithmeticException(
						"Exception " + ArithmeticException.class + " - Erro ao tentar dividir " + v1
								+ " por " + v2 + ".");
			System.out.println("O resultado da divisao de " + v1 + " por " + v2 + " eh: " + v1 / v2);
		};
		int num1 = 50, num2 = 10;
		try {
			divideValores.accept(num1, num2); // esperado: 5
			divideValores.accept(num2, 0); // esperado: exception
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}