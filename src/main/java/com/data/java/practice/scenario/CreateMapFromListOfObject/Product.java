package com.data.java.practice.scenario.CreateMapFromListOfObject;

public class Product {
    public String productID;
    public double price;

    public boolean inStock;

    public Product(String productID, double price, boolean inStock) {
        this.productID = productID;
        this.price = price;
        this.inStock = inStock;
    }
}
