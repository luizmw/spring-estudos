# funções lambda - o que eh:
> Funções lambda em Java são expressões que permitem representar métodos anônimos de forma concisa, facilitando a implementação de interfaces funcionais (interfaces com um único método abstrato). Elas tornam o código mais enxuto e legível, sendo amplamente utilizadas em operações com coleções, programação funcional e APIs modernas do Java, como Streams. As funções lambda foram introduzidas a partir do Java 8.


## Projeto Lambda Java Spring

Exemplos diretos de uso de expressões lambda em Java com Spring Boot.

### Enunciados

> 1 - Crie uma expressão lambda que multiplique dois números inteiros. A expressão deve ser implementada dentro de uma interface funcional com o método multiplicacao(int a, int b).

> 2 - Implemente uma expressão lambda que verifique se um número é primo.

> 3 - Crie uma função lambda que receba uma string e a converta para letras maiúsculas.

> 4 - Crie uma expressão lambda que verifique se uma string é um palíndromo. A expressão deve ser implementada dentro de uma interface funcional com o método boolean verificarPalindromo(String str). Dica: utilize o método reverse da classe StringBuilder.

> 5 - Implemente uma expressão lambda que recebe uma lista de inteiros e retorna uma nova lista onde cada número foi multiplicado por 3. Dica: a função replaceAll, das Collections, recebe uma interface funcional como parâmetro, assim como vimos na função forEach.

> 6 - Crie uma expressão lambda que ordene uma lista de strings em ordem alfabética. Dica: a função sort, das Collections, recebe uma interface funcional como parâmetro, assim como vimos na função forEach.

> 7 - Crie uma função lambda que recebe dois números e divide o primeiro pelo segundo. A função deve lançar uma exceção de tipo ArithmeticException se o divisor for zero.

### Requisitos

- Java 17+
- Maven

### Como executar

```bash
./mvnw spring-boot:run
```