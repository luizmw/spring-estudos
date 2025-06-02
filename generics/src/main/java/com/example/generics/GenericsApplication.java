package com.example.generics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 * 
 * Demonstra o uso de uma classe genérica de Avaliação para diferentes tipos de itens,
 * como serviços, produtos e assinaturas. Cria exemplos de avaliações, adiciona em uma lista
 * e calcula a média das notas utilizando o método estático da classe Avaliacao.
 * 
 * @author SeuNome
 */
@SpringBootApplication
public class GenericsApplication implements CommandLineRunner {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     * 
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(GenericsApplication.class, args);
    }

    /**
     * Executa a lógica principal ao iniciar a aplicação.
     * Cria avaliações genéricas, adiciona em uma lista e calcula a média das notas.
     * 
     * @param args argumentos de linha de comando
     * @throws Exception caso ocorra algum erro durante a execução
     */
    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nInicializando aplicação...");

        var avaliacao1 = new Avaliacao<>("servico", 8, "simulando um obj do tipo Servico");
        var avaliacao2 = new Avaliacao<>("produto", 9, "simulando um obj do tipo Produto");
        var avaliacao3 = new Avaliacao<>("assinatura", 5, "simulando um obj do tipo Assinatura");

        // lista de avaliacoes
        List avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacao1);
        avaliacoes.add(avaliacao2);
        avaliacoes.add(avaliacao3);

        // obtendo avaliacao dos objetos T adicionados na lista e clasificados
        var respAvaliacoes = avaliacao1.calculaMediaNotas(avaliacoes);
        System.out.println("media de avalicoes: " + respAvaliacoes);
    }

}