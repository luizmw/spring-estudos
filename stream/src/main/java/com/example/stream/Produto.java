package com.example.stream;

public class Produto {
    private String name;
    private double price;
    private String category;
    private static int auxId = 0;
    private int id;

    public Produto(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        Produto.auxId++;
        this.id = auxId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto " + getId() + " [name=" + name + ", price=" + price + ", category=" + category + ", id=" + id
                + "]";
    }

}
