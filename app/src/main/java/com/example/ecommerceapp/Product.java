package com.example.ecommerceapp;

public class Product {
    private String name;
    private double price;
    private int imageResource;

    public Product(String name, double price, int imageResource) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
