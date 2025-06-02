package com.example.generics;

import java.util.List;

/**
 * Classe genérica que representa uma avaliação de um item de tipo T.
 * Pode ser utilizada para avaliar diferentes tipos de objetos, como Serviços, Produtos ou Assinaturas.
 *
 * @param <T> o tipo do item avaliado
 */
public class Avaliacao<T> {
    private T item;
    private double nota;
    private String comentario;

    /**
     * Construtor da classe Avaliacao.
     *
     * @param item       o item avaliado, de tipo genérico T
     * @param nota       a nota atribuída à avaliação (deve estar entre 0 e 10)
     * @param comentario o comentário sobre a avaliação
     * @throws IllegalArgumentException se a nota não estiver entre 0 e 10
     */
    public Avaliacao(T item, double nota, String comentario) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
        this.item = item;
        this.nota = nota;
        this.comentario = comentario;
    }

    /**
     * Retorna o item avaliado.
     *
     * @return o item avaliado
     */
    public T getItem() {
        return item;
    }

    /**
     * Define o item avaliado.
     *
     * @param item o novo item avaliado
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * Retorna a nota da avaliação.
     *
     * @return a nota da avaliação
     */
    public double getNota() {
        return nota;
    }

    /**
     * Define a nota da avaliação.
     *
     * @param nota a nova nota (deve estar entre 0 e 10)
     * @throws IllegalArgumentException se a nota não estiver entre 0 e 10
     */
    public void setNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
        this.nota = nota;
    }

    /**
     * Retorna o comentário da avaliação.
     *
     * @return o comentário da avaliação
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define o comentário da avaliação.
     *
     * @param comentario o novo comentário
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Calcula a média das notas de uma lista de avaliações.
     *
     * @param avaliacoes a lista de avaliações
     * @param <T>        o tipo do item avaliado
     * @return a média das notas
     * @throws IllegalArgumentException se a lista de avaliações estiver vazia
     */
    public static <T> double calculaMediaNotas(List<Avaliacao<T>> avaliacoes) {
        if (avaliacoes.isEmpty()) {
            throw new IllegalArgumentException("A lista de avaliacoes esta vazia");
        }
        double soma = 0;
        for (Avaliacao<T> avaliacao : avaliacoes) {
            soma += avaliacao.getNota();
        }
        return soma / avaliacoes.size();
    }

    /**
     * Retorna uma representação em String da avaliação.
     *
     * @return uma string contendo o item, a nota e o comentário
     */
    @Override
    public String toString() {
        return "Avaliacao [item=" + item + ", nota=" + nota + ", comentario=" + comentario + "]";
    }

}