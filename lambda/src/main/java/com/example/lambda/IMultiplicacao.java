package com.example.lambda;

/**
 * Interface funcional para realizar a multiplicação de dois números inteiros.
 * <p>
 * Esta interface pode ser utilizada como alvo para expressões lambda ou referências de método
 * que implementem a operação de multiplicação.
 * </p>
 */
@FunctionalInterface //indica que a Interace tera apenas um método abstrato - interface funcional
public interface IMultiplicacao {
    /**
     * Realiza a multiplicação de dois números inteiros.
     *
     * @param a o primeiro fator
     * @param b o segundo fator
     * @return o resultado da multiplicação de {@code a} por {@code b}
     */
    int multiplicar(int a, int b);
}

