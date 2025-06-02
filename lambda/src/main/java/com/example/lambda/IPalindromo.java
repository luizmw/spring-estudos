package com.example.lambda;

/**
 * Interface funcional para verificar se uma palavra é um palíndromo.
 * <p>
 * Esta interface pode ser utilizada como alvo para expressões lambda ou referências de método
 * que implementem a lógica de verificação de palíndromos.
 * </p>
 */
@FunctionalInterface
public interface IPalindromo {
    /**
     * Verifica se a palavra fornecida é um palíndromo.
     *
     * @param palavra a palavra a ser verificada
     * @return {@code true} se a palavra for um palíndromo, {@code false} caso contrário
     */
    Boolean verificaPalindromo(String palavra);
}
