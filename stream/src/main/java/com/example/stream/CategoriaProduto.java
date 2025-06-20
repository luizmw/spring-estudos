package com.example.stream;

public enum CategoriaProduto {
    // constantes que chamam o construtor
    ELETRONICOS("Eletronicos"), 
    FERRAMENTAS("Ferramentas");

    private final String nome; // variavel que armazena o valor da constante

    private CategoriaProduto(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome associado à constante do enum
     * 
     * @return o nome como uma String
     */
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
