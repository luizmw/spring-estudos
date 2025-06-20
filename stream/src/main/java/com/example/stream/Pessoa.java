package com.example.stream;

public class Pessoa {
    private String nome;
    private int idade;
    private static int auxid = 0;
    private int id;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        Pessoa.auxid++;
        this.id = auxid;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pessoa "+this.id+" [nome=" + nome + ", idade=" + idade + "]";
    }

}
