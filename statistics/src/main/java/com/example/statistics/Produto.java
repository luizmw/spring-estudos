package com.example.statistics;

public class Produto {
    private String name;
    private Double price;
    private String category;

    public Produto(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return " Product [name=" + name + ", price=" + price + ", category=" + category + "] ";
    }

    
}
