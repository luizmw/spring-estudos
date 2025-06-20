## Stream API - o que é:
> Stream API em Java é uma abstração que permite processar coleções de dados de forma declarativa e funcional. Introduzida no Java 8, a Stream API fornece uma interface fluente para realizar operações como filtragem, mapeamento, ordenação e redução de dados de maneira eficiente e legível. Diferentemente das coleções tradicionais, os Streams não armazenam dados, mas sim processam elementos sob demanda, permitindo operações intermediárias (lazy) e terminais que podem ser encadeadas para criar pipelines de processamento poderosos e expressivos.

## Prjeto Stream Java Spring
Exemplos diretos de streams em Java com Spring Boot.

### Enunciados
> 1 - Considere uma lista de números inteiros (1 a 10), filtre apenas os números pares e imprima-os.

> 2 - Considere uma lista de palavras (strings), converta para letras maiusculas e imprima-as

> 3 - Considere uma lista de inteiros (1 a 10), filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista.

> 4 - Considere uma lista de string com palavras duplicadas, remova-as e imprima o resultado

> 5 - Dada uma lista de sublistas com inteiros (List<List<Integer>> listaDeNumeros = Arrays.asList(
    Arrays.asList(1, 2, 3, 4),
    Arrays.asList(5, 6, 7, 8),
    Arrays.asList(9, 10, 11, 12)
        );)
extraia todos numeros primos em uma lista unica e ordene em sentido crescente

> 6 - Dados um objeto Pessoa (nome, idade), filtre as pessoas com mais de 18 anos, extraia os nome e imprima-os em ordem alfabética

> 7 - Dada uma lista de objetos do tipo Produt(nome, preco, categoria), filtre todos produtos da categoria "eletronicos" com preço menor que R$1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista

> 8 - Para a lista do exercicio anterior, extrai os três produtos mais baratos abaixo de R$1000

## Requisitos 
> Java 17+
> Maven
> Spring Boot

## Como executar
> ./mvnw spring-boot:run